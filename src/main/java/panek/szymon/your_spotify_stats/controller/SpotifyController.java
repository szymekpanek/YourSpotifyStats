package panek.szymon.your_spotify_stats.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import panek.szymon.your_spotify_stats.dto.UserProfileDTO;
import panek.szymon.your_spotify_stats.service.SpotifyService;
import reactor.core.publisher.Mono;

@RestController
public class SpotifyController {

    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/user-profile")
    public Mono<UserProfileDTO> getUserProfile(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient) {
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        return spotifyService.getUserProfile(accessToken);
    }
}
