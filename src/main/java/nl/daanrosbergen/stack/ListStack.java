package nl.daanrosbergen.stack;

import nl.daanrosbergen.linkedlist.Lijst;
import nl.daanrosbergen.linkedlist.LijstImpl;

public class ListStack implements Stack {
    private Lijst lijst;

    public ListStack() {
        lijst = new LijstImpl();
    }

    @Override public void push(Object o) {
        lijst.addLast(o);
    }

    @Override public Object pop() {
        return lijst.removeLast();
    }

    @Override public Object peek() {
        return lijst.getLast();
    }

    @Override public int size() {
        return lijst.size();
    }

    @Override public boolean isEmpty() {
        return (lijst.size() == 0);
    }
}
