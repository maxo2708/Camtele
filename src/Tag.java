public abstract class Tag {
    Posts postings;
    String name;
    public Tag(String name) {
        this.postings = new Posts();
        this.name = name;
    }
    public Posts getPosts() {
        return this.postings;
    }
}