package panek.szymon.your_spotify_stats.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import panek.szymon.your_spotify_stats.dto.UserProfileDTO;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest
public class SpotifyServiceTest {
    @Autowired
    SpotifyService spotifyService;

    @Test
    public void testGetUserProfile() {
        // Użyj prawdziwego lub przykładowego tokena dostępu (dla testów warto zamockować odpowiedź)
        String dummyAccessToken = "VALID_ACCESS_TOKEN";

        Mono<UserProfileDTO> userProfileMono = spotifyService.getUserProfile(dummyAccessToken);

        StepVerifier.create(userProfileMono)
                .expectNextMatches(userProfile -> userProfile.getId() != null)
                .verifyComplete();
    }

}
