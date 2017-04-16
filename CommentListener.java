import java.io.Serializable;

public class CommentListener implements Listener, Serializable {
    Account acc;
    public CommentListener(Account acc) {
        this.acc = acc;
    }
    public void notify(String from) {
        acc.addNotification(new Notification("New Comment", from));
    }

}