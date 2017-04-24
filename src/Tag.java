public class Tag implements Comparable {
    Posts postings;
    String name;
    public Tag(String name) {
        this.postings = new Posts();
        this.name = name;
    }
    public Posts getPosts() {
        return this.postings;
    }
    public String getName() { return this.name; }
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
        Tag t2 = (Tag) obj;
        return this.getName().equals(t2.getName());
    }
    public int compareTo(Object obj) {
        Tag t2 = (Tag) obj;
        return this.getName().compareTo(t2.getName());
    }
}