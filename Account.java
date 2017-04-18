import javax.swing.event.ChangeListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable, Comparable {
    private String username;
    private String password;
    private String securityAnswer;
    private String bio;
    private String avatar;
    private String nickname;
    private Posts postsMade;
    private ArrayList<ChangeListener> listeners;
    private Accounts following;
    private Accounts followers;
    private Notifications notifs;
    private Posts feed;

    public Account(String username, String password, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.securityAnswer = securityAnswer;
        this.bio = "";
        this.avatar = "";
        this.nickname = "";
        this.postsMade = new Posts();
        this.following = new Accounts();
        this.followers = new Accounts();
        this.notifs = new Notifications();
        this.listeners = new ArrayList<ChangeListener>();
    }
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }
    public boolean checkSecurityAnswer(String ans) { return this.securityAnswer.equals(ans); }

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
    public Accounts getFollowers() {
        return this.followers;
    }
    public Accounts getFollowing() {
        return this.following;
    }

    // Extra Methods

    public void follow(Account acc, ChangeListener listener) {
            // Add user to followers array
            this.followers.add(acc);

            listeners.add(listener);
            // Notify user of new follower
            this.notifs.add(new Notification("New Follower", acc.getNickname()));
    }
    public void addNotification(Notification n) {
        this.notifs.add(n);
    }


    public String toString() {
        return "Username: " + this.getUsername() + "\n" +
                "Nickname: " + this.getNickname() + "\n" +
                "Bio: " + this.getBio();
    }

    /**
     * Checks for equality by checking the username
     * @param obj the object to check for equality
     * @return whether or not the object is equal to this
     */
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
       Account acc2 = (Account) obj;
       return acc2.getUsername().equals(this.getUsername());
    }
    public int compareTo(Object obj) {
        Account a2 = (Account) obj;
        return this.username.compareTo(a2.getUsername());
    }


}