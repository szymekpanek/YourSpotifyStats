package panek.szymon.your_spotify_stats.service;

import org.springframework.stereotype.Service;
import panek.szymon.your_spotify_stats.model.Track;

import java.util.List;

@Service
public class PopularityService {
    public double getAveragePopularity(List<Track> tracks) {
        return tracks.stream()
                .mapToInt(Track::getPopularity)
                .average()
                .orElse(0.0);
    }
}
