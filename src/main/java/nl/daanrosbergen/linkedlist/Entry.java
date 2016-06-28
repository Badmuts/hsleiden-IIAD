package nl.daanrosbergen.linkedlist;

public class Entry
{
    Entry previous;
    Object element;
    Entry next;

    Entry( Entry previous, Object element, Entry next )
    {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }
}
