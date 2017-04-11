import java.util.ArrayList;

public class Posts implements Listing<Post> {
    
    ArrayList<Post> postings;

    public Posts() {
        this.postings = new ArrayList<Post>();
    }
    public boolean add(Post p) {
        return this.postings.add(p);
    }
    public Post remove(int index) {
        return this.postings.remove(index);
    }
    public Post get(int index) {
        return this.postings.get(index);
    }
}