package panek.szymon.your_spotify_stats.service;

import panek.szymon.your_spotify_stats.dto.*;
import reactor.core.publisher.Mono;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Map;

public interface ISpotifyService {
    // Metody komunikacji z API Spotify:

    // Pobiera dane o profilu użytkownika.
    Mono<UserProfileDTO> getUserProfile(String accessToken);

    // Pobiera listę playlist użytkownika.
    Mono<TopTracksResponseDTO> getUserTopTracklists(String accessToken);

    // Pobiera szczegóły konkretnej playlisty (np. nazwa, opis).
    Mono<PlaylistDTO> getPlaylistDetails(String playlistId, String accessToken);

    // Pobiera listę utworów znajdujących się w danej playliście.
    Mono<List<TrackDTO>> getTracksFromPlaylist(String playlistId, String accessToken);


    // Metody analityczne:

    // Oblicza średnie tempo (BPM) utworów.
    double calculateAverageBPM(List<Track> tracks);

    // Oblicza średni poziom energii utworów.
    double calculateAverageEnergy(List<Track> tracks);

    // Oblicza średnią wartość danceability (czyli jak taneczne są utwory).
    double calculateAverageDanceability(List<Track> tracks);

    // Oblicza średnią popularność utworów.
    double calculateAveragePopularity(List<Track> tracks);

    // Oblicza rozkład gatunkowy – na przykład ile utworów należy do danego gatunku.
    Map<String, Long> calculateGenreDistribution(List<Track> tracks);

    // Analizuje sentyment utworu lub tekstu (czy utwór ma pozytywny, negatywny lub neutralny wydźwięk).
    SentimentResultDTO analyzeSentiment(String text);
}
