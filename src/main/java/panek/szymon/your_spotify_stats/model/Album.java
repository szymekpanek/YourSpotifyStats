package panek.szymon.your_spotify_stats.model;

import panek.szymon.your_spotify_stats.model.Image;

import java.util.List;

public class Album {
    private String id;
    private String name;
    private List<Image> images; // Obrazy albumu

    // Gettery i settery
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
