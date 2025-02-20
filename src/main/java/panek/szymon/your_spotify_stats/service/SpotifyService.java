package panek.szymon.your_spotify_stats.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import panek.szymon.your_spotify_stats.dto.*;
import reactor.core.publisher.Mono;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Map;

@Service
public class SpotifyService implements ISpotifyService{

    private final WebClient webClient;

    public SpotifyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<UserProfileDTO> getUserProfile(String accessToken) {
        return webClient.get()
                .uri("https://api.spotify.com/v1/me")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(UserProfileDTO.class);
    }

    @Override
    public Mono<TopTracksResponseDTO> getUserTopTracklists(String accessToken) {
        return webClient.get()
                .uri("https://api.spotify.com/v1/me/top/tracks")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(TopTracksResponseDTO.class);
    }

    @Override
    public Mono<PlaylistDTO> getPlaylistDetails(String playlistId, String accessToken) {
        return null;
    }

    @Override
    public Mono<List<TrackDTO>> getTracksFromPlaylist(String playlistId, String accessToken) {
        return null;
    }

    @Override
    public double calculateAverageBPM(List<Track> tracks) {
        return 0;
    }

    @Override
    public double calculateAverageEnergy(List<Track> tracks) {
        return 0;
    }

    @Override
    public double calculateAverageDanceability(List<Track> tracks) {
        return 0;
    }

    @Override
    public double calculateAveragePopularity(List<Track> tracks) {
        return 0;
    }

    @Override
    public Map<String, Long> calculateGenreDistribution(List<Track> tracks) {
        return null;
    }

    @Override
    public SentimentResultDTO analyzeSentiment(String text) {
        return null;
    }
}
