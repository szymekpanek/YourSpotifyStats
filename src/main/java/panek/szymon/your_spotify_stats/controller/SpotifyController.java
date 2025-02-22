package panek.szymon.your_spotify_stats.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import panek.szymon.your_spotify_stats.model.Track;
import panek.szymon.your_spotify_stats.service.SpotifyService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class SpotifyController {

    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/top-tracks")
    public List<Track> getTopTracks(OAuth2AuthenticationToken authentication) {
        return spotifyService.getUserTopTracks(authentication);
    }

    @GetMapping("/average-popularity")
    public ResponseEntity<Double> getAveragePopularity(OAuth2AuthenticationToken authentication) {
        double averagePopularity = spotifyService.getAveragePopularity(authentication);
        return ResponseEntity.ok(averagePopularity);
    }
    @GetMapping("/auth-token")
    public void getAuthToken(OAuth2AuthenticationToken authentication, HttpServletResponse response) {
        String accessToken = spotifyService.getAccessToken(authentication);

        // Tworzymy ciasteczko
        Cookie cookie = new Cookie("access_token", accessToken);
        cookie.setHttpOnly(true); // Bezpieczne ciasteczko
        cookie.setSecure(true);   // Wymaga HTTPS, w zależności od środowiska produkcyjnego
        cookie.setPath("/");      // Ciasteczko dostępne w całej aplikacji
        response.addCookie(cookie); // Dodajemy ciasteczko do odpowiedzi
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        // Po wylogowaniu przekierowujemy użytkownika do autoryzacji Spotify
        response.sendRedirect("http://localhost:8080/oauth2/authorization/spotify");
    }

}
