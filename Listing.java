public interface Listing<E> {
    public boolean add(E item);
    public E get(int index);
    public E remove(int index);
    public int size();
}