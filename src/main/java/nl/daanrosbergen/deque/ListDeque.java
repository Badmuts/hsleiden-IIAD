package nl.daanrosbergen.deque;

import nl.daanrosbergen.linkedlist.Lijst;
import nl.daanrosbergen.linkedlist.LijstImpl;

public class ListDeque implements Deque {
    Lijst lijst = new LijstImpl();

    @Override public void addFirst(Object o) {
        lijst.addFirst(o);
    }

    @Override public void addLast(Object o) {
        lijst.addLast(o);
    }

    @Override public Object removeFirst() {
        return lijst.removeFirst();
    }

    @Override public Object removeLast() {
        return lijst.removeLast();
    }

    @Override public Object getFirst() {
        return lijst.getFirst();
    }

    @Override public Object getLast() {
        return lijst.getLast();
    }

    @Override public int size() {
        return lijst.size();
    }

    @Override public boolean isEmpty() {
        return (lijst.size() == 0);
    }
}
