import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Tags implements Listing<Tag>, Serializable {
    ArrayList<Tag> tags;

    public Tags() {
        this.tags = new ArrayList<Tag>();
    }

    public boolean add(Tag t) {
        boolean addedSuccessfully = this.tags.add(t);
        Collections.sort(this.tags);
        return addedSuccessfully;
    }

    public Tag remove(int index) {
        return this.tags.remove(index);
    }

    public Tag get(int index) {
        return this.tags.get(index);
    }
    public Tag get(String tagname) {
        for (Tag t: this.tags) {
            if (t.getName().equals(tagname)) {
                return t;
            }
        }
        Tag newTag = new Tag(tagname);
        this.tags.add(newTag);
        return newTag;
    }

    public int size() { return this.tags.size(); }

    public String toString() {
        String returns = "";
        for (Tag t: this.tags) {
            returns += t.toString();
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
        Tags tags2 = (Tags) obj;
        if (this.tags.size() != tags2.size()) {
            return false;
        }
        // Assumption: Structure is sorted before comparing indexes
        for (int i = 0; i < this.tags.size(); i++) {
            if (!this.tags.get(i).equals(tags2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
