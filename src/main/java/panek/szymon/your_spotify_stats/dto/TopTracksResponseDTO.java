package panek.szymon.your_spotify_stats.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;
@Getter
@Data
public class TopTracksResponseDTO {
    // Lista najczęściej słuchanych utworów
    private List<TrackDTO> items;

    // Całkowita liczba utworów, które pasują do kryterium
    private int total;

    // Maksymalna liczba elementów zwróconych w jednym żądaniu (limit)
    private int limit;

    // Przesunięcie, od którego zaczęto zwracać wyniki (offset)
    private int offset;

    // URL do pobrania następnej strony wyników (jeśli jest dostępna)
    private String next;

    // URL do pobrania poprzedniej strony wyników (jeśli jest dostępna)
    private String previous;
}
