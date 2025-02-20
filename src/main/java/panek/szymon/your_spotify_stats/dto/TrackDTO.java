package panek.szymon.your_spotify_stats.dto;

import lombok.Data;

@Data
public class TrackDTO {
    private String id;
    private String name;
    private double bpm;
    private double energy;
    private double danceability;
    private int popularity;
}
