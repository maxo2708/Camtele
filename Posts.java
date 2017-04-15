import java.io.Serializable;
import java.util.ArrayList;
public class Posts implements Listing<Post>, Serializable {
    ArrayList<Post> postings;

    public Posts() {
        this.postings = new ArrayList<Post>();
    }
    public boolean add(Post p) {
        boolean success = this.postings.add(p);
        // Run insertion sort
        return success;
    }
    public Post remove(int index) {
        return this.postings.remove(index);
    }
    public Post get(int index) {
        return this.postings.get(index);
    }
    public int size() { return this.postings.size(); }
}