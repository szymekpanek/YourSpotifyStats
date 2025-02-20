package panek.szymon.your_spotify_stats.dto;

import lombok.Data;
import java.util.Map;

@Data
public class AnalysisResultDTO {
    private double averageBPM;
    private double averageEnergy;
    private double averageDanceability;
    private double averagePopularity;
    private Map<String, Long> genreDistribution; // Klucz: nazwa gatunku, Wartość: liczba utworów
    private SentimentResultDTO sentimentResult;
}
