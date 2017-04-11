import java.awt.event.ChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
public class Post {
    private String imageURI;
    private String description;
    private LocalDateTime timeCreated;
    private Comments coms;
    private ArrayList<ChangeListener> listeners;
    public Post(String imageURI, String description) {
        this.imageURI = imageURI;
        this.description = description;
        this.timeCreated = LocalDateTime.now();
        this.coms = new Comments();
        this.listeners = new ArrayList<ChangeListener>();
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
    //public void addComment(Account from, Comment com) {
     //   this.coms.add(com);
     //   for (ChangeListener listener : listeners) {
            
     //   }
   // }
}