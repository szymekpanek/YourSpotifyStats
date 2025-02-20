package panek.szymon.your_spotify_stats.dto;

import lombok.Data;
import java.util.List;

@Data
public class PlaylistDTO {
    private String id;
    private String name;
    private String description;
    private List<TrackDTO> tracks;
}
