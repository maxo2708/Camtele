import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Posts implements Listing<Post>, Serializable {
    ArrayList<Post> postings;

    public Posts() {
        this.postings = new ArrayList<Post>();
    }
    public boolean add(Post p) {
        boolean success = false;
        if (!this.contains(p)) {
            success = this.postings.add(p);
        }
        Collections.sort(postings);
        return success;
    }
    public Post remove(int index) {
        return this.postings.remove(index);
    }
    public Post get(int index) {
        return this.postings.get(index);
    }
    public boolean contains(Post p) {
        for (int i = 0; i < this.postings.size(); i++) {
            if (this.postings.get(i).equals(p)) {
                return true;
            }
        }
        return false;
    }
    public int size() { return this.postings.size(); }

    public String toString() {
        String returns = "";
        for (Post p: postings) {
            returns += p.toString();
        }
        return returns;
    }
    
    public void add(Posts ps) {
        for (int i = 0; i < ps.size(); i++) {
            this.add(ps.get(i));
        }
    }

    //public boolean equals(Object obj) {
    //    if (this == obj) {
    //        return true;
    //    }
    //    if (obj == null) {
    //        return false;
    //    }
    //    if (this.getClass() != obj.getClass()) {
    //        return false;
    //    }
    //    return false;
    //}
}
