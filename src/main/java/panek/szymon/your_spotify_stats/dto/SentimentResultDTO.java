package panek.szymon.your_spotify_stats.dto;

import lombok.Data;

@Data
public class SentimentResultDTO {
    private String sentiment;  // np. "positive", "negative", "neutral"
    private double score;      // Wynik analizy sentymentu
}
