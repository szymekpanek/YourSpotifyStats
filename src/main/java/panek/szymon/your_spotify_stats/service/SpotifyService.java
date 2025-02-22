package panek.szymon.your_spotify_stats.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import panek.szymon.your_spotify_stats.dto.*;
import panek.szymon.your_spotify_stats.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpotifyService {

    private final RestTemplate restTemplate;
    private final OAuth2AuthorizedClientService authorizedClientService;
    private final PopularityService popularityService;

    public SpotifyService(RestTemplate restTemplate, OAuth2AuthorizedClientService authorizedClientService, PopularityService popularityService) {
        this.restTemplate = restTemplate;
        this.authorizedClientService = authorizedClientService;
        this.popularityService = popularityService;
    }

    public List<Track> getUserTopTracks(OAuth2AuthenticationToken authentication) {
        // Pobieramy token dostępu
        String accessToken = getAccessToken(authentication);

        // Pobieramy topowe utwory
        List<Track> tracks = getTopTracks(accessToken);

        // Mapujemy dane dla każdego utworu
        return tracks.stream()
                .map(this::mapTrackData)
                .collect(Collectors.toList());
    }

    public String getAccessToken(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName()
        );
        return client.getAccessToken().getTokenValue();
    }

    private List<Track> getTopTracks(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        String urlTopTracks = "https://api.spotify.com/v1/me/top/tracks?limit=50";
        ResponseEntity<TopTracksResponseDTO> topTracksResponse = restTemplate.exchange(
                urlTopTracks,
                HttpMethod.GET,
                requestEntity,
                TopTracksResponseDTO.class
        );

        return topTracksResponse.getBody().getItems();
    }

    private List<Artist> getArtistsForTrack(Track track) {
        return track.getArtists().stream()
                .map(artist -> new Artist(artist.getId(), artist.getName()))
                .collect(Collectors.toList());
    }

    private Album getAlbumForTrack(Track track) {
        Album album = new Album();
        album.setId(track.getAlbum().getId());
        album.setName(track.getAlbum().getName());
        album.setImages(track.getAlbum().getImages().stream()
                .map(image -> new Image(image.getUrl()))
                .collect(Collectors.toList()));
        return album;
    }

    private Track mapTrackData(Track track) {
        List<Artist> artists = getArtistsForTrack(track);
        Album album = getAlbumForTrack(track);

        track.setArtists(artists);
        track.setAlbum(album);
        track.setPopularity(track.getPopularity());

        return track;
    }

    public double getAveragePopularity(OAuth2AuthenticationToken authentication) {
        // Pobieramy token dostępu
        String accessToken = getAccessToken(authentication);

        List<Track> favoriteTracks = getTopTracks(accessToken);

        return popularityService.getAveragePopularity(favoriteTracks);
    }

}
