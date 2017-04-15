import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Post implements Serializable {
    private String imageURI;
    private String description;
    private LocalDateTime timeCreated;
    private Comments coms;
    private ArrayList<CommentListener> listeners;
    private String author;
    // Keep track of who likes the post here
    public Post(Account acc, String imageURI, String description) {
        this.imageURI = imageURI;
        this.description = description;
        this.timeCreated = LocalDateTime.now();
        this.coms = new Comments();
        this.listeners = new ArrayList<CommentListener>();
        this.author = acc.getNickname();
        this.listeners.add(new CommentListener(acc));
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
    public String getAuthor() {
        return this.author;
    }

    // Mutators

    public void setImageURI(String uri) {
        this.imageURI = uri;
    }
    public void setDescription(String desc) {
        this.description = desc;
    }
    public void addComment(Comment com) {
       this.coms.add(com);
       for (Listener listener : listeners) {
            listener.notify(com.getFrom());
       }
    }

    // Extras
    public void likePost(Account acc) {
        // Add to list of people who liked the post here
        for (Listener listener: listeners) {
            listener.notify(acc.getNickname());
        }
    }
    public void dislikePost(Account acc) {
        // Remove account from likes list
    }

    public String toString() {
        return "Date Created: " + this.getTimeCreated().toString() + "\n" +
                "Image URI: " + this.getImageURI() + "\n" +
                "Description: " + this.getDescription();
    }
}