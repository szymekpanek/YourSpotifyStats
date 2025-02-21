package panek.szymon.your_spotify_stats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SpotifyServiceTest {
    @Autowired
    SpotifyService spotifyService;

//    @Test
//    public void testGetUserProfile() {
//        // Użyj prawdziwego lub przykładowego tokena dostępu (dla testów warto zamockować odpowiedź)
//        String dummyAccessToken = "VALID_ACCESS_TOKEN";
//
//        Mono<UserProfile> userProfileMono = spotifyService.getUserProfile(dummyAccessToken);
//
//        StepVerifier.create(userProfileMono)
//                .expectNextMatches(userProfile -> userProfile.getId() != null)
//                .verifyComplete();
//    }

}
