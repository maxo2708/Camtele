
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirstyn
 */
public class Comments implements Listing<Comment> {
    ArrayList<Comment> comments;
    
    public Comments() {
        this.comments = new ArrayList<Comment>();
    }
    
    public boolean add(Comment c) {
        return this.comments.add(c);
    }
    
    public Comment remove(int index) {
        return this.comments.remove(index);
    }
    
    public Comment get(int index) {
        return this.comments.get(index);
    }
}
