
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirstyn
 */
public class Comments implements Listing<Comment>, Serializable {
    ArrayList<Comment> comments;
    
    public Comments() {
        this.comments = new ArrayList<Comment>();
    }
    
    public boolean add(Comment c) {
        boolean addedSuccessfully = this.comments.add(c);
        Collections.sort(this.comments);
        return addedSuccessfully;
    }
    
    public Comment remove(int index) {
        return this.comments.remove(index);
    }
    
    public Comment get(int index) {
        return this.comments.get(index);
    }

    public int size() { return this.comments.size(); }

    public String toString() {
        String returns = "";
        for (Comment c : comments) {
            returns += c.toString();
        }
        return returns;
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
        Comments comms2 = (Comments) obj;
        if (this.comments.size() != comms2.size()) {
            return false;
        }
        // Assumption: Structure is sorted before comparing indexes
        for (int i = 0; i < this.comments.size(); i++) {
            if (!this.comments.get(i).equals(comms2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
