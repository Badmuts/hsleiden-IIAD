package nl.daanrosbergen.linkedlist;

public interface Lijst {
    public void addFirst(Object o);
    public Object getFirst();
    public Object removeFirst();

    public void addLast(Object o);
    public Object getLast();
    public Object removeLast();

    public Iterator iterator();

    public int size();
    public void clear();
}
