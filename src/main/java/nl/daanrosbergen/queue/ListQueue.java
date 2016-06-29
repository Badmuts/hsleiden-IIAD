package nl.daanrosbergen.queue;

import nl.daanrosbergen.linkedlist.Lijst;
import nl.daanrosbergen.linkedlist.LijstImpl;

public class ListQueue implements Queue {
    Lijst lijst = new LijstImpl();

    @Override public void enqueue(Object o) {
        lijst.addLast(o);
    }

    @Override public Object dequeue() {
        return lijst.removeFirst();
    }

    @Override public Object front() {
        return lijst.getFirst();
    }

    @Override public int size() {
        return lijst.size();
    }

    @Override public boolean isEmpty() {
        return (lijst.size() == 0);
    }
}
