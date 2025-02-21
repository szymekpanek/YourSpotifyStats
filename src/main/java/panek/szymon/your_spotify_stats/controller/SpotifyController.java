package panek.szymon.your_spotify_stats.controller;


import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import panek.szymon.your_spotify_stats.model.Track;
import panek.szymon.your_spotify_stats.model.UserProfile;
import panek.szymon.your_spotify_stats.service.SpotifyService;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SpotifyController {

    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/user-profile")
    public Mono<UserProfile> getUserProfile(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient) {
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        return spotifyService.getUserProfile(accessToken);
    }
    @GetMapping("/top-tracks")
    public List<Track> getTopTracks(OAuth2AuthenticationToken authentication) {
        return spotifyService.getUserTopTracks(authentication);
    }
}


