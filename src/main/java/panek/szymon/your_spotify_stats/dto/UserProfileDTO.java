package panek.szymon.your_spotify_stats.dto;

import lombok.Data;



@Data
public class UserProfileDTO {
    private String id;
    private String displayName;
    private String email;

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }
}

