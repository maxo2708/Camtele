import java.util.Date;
public class Post {
    String imageURI;
    String description;
    Date timeCreated;
    public Post(String imageURI, String description) {
        this.imageURI = imageURI;
        this.description = description;
        this.timeCreated = Date.now();
    }

    // Accessors

    public String getImageURI() {
        return this.imageURI;
    }
    public String getDescription() {
        return this.description;
    }
    public Date getTimeCreated() {
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