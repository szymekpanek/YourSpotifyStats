package panek.szymon.your_spotify_stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import panek.szymon.your_spotify_stats.model.Track;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopTracksResponseDTO {
    private List<Track> items;

    public List<Track> getItems() {
        return items;
    }

}
