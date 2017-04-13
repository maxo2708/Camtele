public class CommentListener implements Listener {
    Account acc;
    public CommentListener(Account acc) {
        this.acc = acc;
    }
    public void notify(String from) {
        acc.addNotification(new Notification("New Comment", from));
    }

}