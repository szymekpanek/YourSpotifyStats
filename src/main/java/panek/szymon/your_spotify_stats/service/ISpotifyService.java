package panek.szymon.your_spotify_stats.service;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import panek.szymon.your_spotify_stats.model.Album;
import panek.szymon.your_spotify_stats.model.Artist;
import panek.szymon.your_spotify_stats.model.Track;
import panek.szymon.your_spotify_stats.model.UserProfile;
import reactor.core.publisher.Mono;


import java.util.List;

public interface ISpotifyService {
    List<Track> getUserTopTracks(OAuth2AuthenticationToken authentication);

    double getAveragePopularity(OAuth2AuthenticationToken authentication);

    Track mapTrackData(Track track);

    Album getAlbumForTrack(Track track);

    List<Artist> getArtistsForTrack(Track track);

    List<Track> getTopTracks(String accessToken);

    String getAccessToken(OAuth2AuthenticationToken authentication);

}
