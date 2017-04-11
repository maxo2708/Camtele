import java.time.LocalDateTime;

public class Post {
    
    String imageURI;
    String description;
    LocalDateTime timeCreated;
    
    public Post(String imageURI, String description) {
        this.imageURI = imageURI;
        this.description = description;
        this.timeCreated = LocalDateTime.now();
    }

    // Accessors

    public String getImageURI() {
        return this.imageURI;
    }
    public String getDescription() {
        return this.description;
    }
    public LocalDateTime getTimeCreated() {
        return this.timeCreated;
    }

    // Mutators

    public void setImageURI(String uri) {
        this.imageURI = uri;
    }
    public void setDescription(String desc) {
        this.description = desc;
    }
}
