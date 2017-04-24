import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post implements Serializable, Comparable {
    private String imageURI;
    private String description;
    private LocalDateTime timeCreated;
    private Comments coms;
    private ArrayList<CommentListener> listeners;
    private Accounts likedBy;
    private String author;
    private String location;
    // Keep track of who likes the post here
    public Post(Account acc, String imageURI, String description) {
        this.imageURI = imageURI;
        this.setDescription(description);
        this.timeCreated = LocalDateTime.now();
        this.coms = new Comments();
        this.listeners = new ArrayList<>();
        this.author = acc.getUsername();
        this.listeners.add(new CommentListener(acc));
        this.likedBy = new Accounts();
        this.location = "";
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
    public Comments getComments() { return this.coms; }
    public Accounts getLikes() { return this.likedBy; }
    public String getLocation() { return this.location; }

    // Mutators
    public void setLocation(String loc) { this.location = loc; }
    public void setImageURI(String uri) {
        this.imageURI = uri;
    }
    public void setDescription(String desc) {
        for (int i = 0; i < desc.length(); i++) {
            if (desc.charAt(i) == '#') {
                for (int k = i; k < desc.length(); k++) {
                    if (desc.charAt(k) == ' ') {
                        Main.accounts.getTag().get(desc.substring(i + 1, k)).getPosts().add(this);
                    } else if (k == desc.length() - 1) {
                        // Add post to the tag
                        Main.accounts.getTag().get(desc.substring(i + 1, k + 1)).getPosts().add(this);
                    }
                }
            }
        }
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
        this.likedBy.add(acc);
        for (Listener listener: listeners) {
            listener.notify(acc.getNickname());
        }
    }
    public void dislikePost(Account acc) {
        // Remove account from likes list
        this.likedBy.remove(acc.getUsername());
        // TODO: Remove notifier

    }

    public int compareTo(Object obj) {
        Post p2 = (Post) obj;
        return this.getTimeCreated().compareTo(p2.getTimeCreated());
    }

    public String toString() {
        return "Date Created: " + this.getTimeCreated().toString() + "\n" +
                "Image URI: " + this.getImageURI() + "\n" +
                "Description: " + this.getDescription();
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Post p2 = (Post) obj;
        return this.getImageURI().equals(p2.getImageURI()) && this.getDescription().equals(p2.getDescription());
    }
}