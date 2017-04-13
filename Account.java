import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private String bio;
    private String avatar;
    private String nickname;
    private Posts postsMade;
    private ArrayList<ChangeListener> listeners;
    private Listing following;
    //private Listing followers;
    private Notifications notifs;
    private Posts feed;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.bio = "";
        this.avatar = "";
        this.nickname = "";
        this.postsMade = new Posts();
        //this.following
        //this.followers
        this.notifs = new Notifications();
        this.listeners = new ArrayList<ChangeListener>();
    }
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    // Mutators
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setNickname(String nick) {
        this.nickname = nick;
    }

    // Accessors 
    public String getUsername() {
        return this.username;
    }
    public String getBio() {
        return this.bio;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public String getNickname() {
        return this.nickname;
    }
    public Posts getPosts() {
        return this.postsMade;
    }
    // public Listing getFollowers()
    // public Listing getFollowing()

    // Extra Methods

    public void follow(Account acc, ChangeListener listener) {
            // Add user to followers array
            listeners.add(listener);
            // Notify user of new follower
            this.notifs.add(new Notification("New Follower", acc.getNickname()));
    }
    public void addNotification(Notification n) {
        this.notifs.add(n);
    }



}