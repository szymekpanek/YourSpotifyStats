package panek.szymon.your_spotify_stats.model;

import java.util.List;

public class Track {
    private String id;
    private String name;
    private List<Artist> artists; // Zawiera listę artystów
    private Album album;          // Zawiera informacje o albumie
    private int popularity;       // Popularność utworu

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
