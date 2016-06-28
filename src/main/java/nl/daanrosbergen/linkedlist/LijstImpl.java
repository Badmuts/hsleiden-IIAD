package nl.daanrosbergen.linkedlist;

import java.util.NoSuchElementException;

public class LijstImpl implements Lijst {
    private Entry header;
    private int size;

    // Constructor voor een lege lijst
    public LijstImpl()
    {
        header = new Entry( null, null, null );
        header.next = header;
        header.previous = header;
    }

    // Object vooraan toevoegen
    public void addFirst( Object element )
    {
        add(header.next.previous, element, header.next);
    }

    // Object vooraan opvragen
    public Object getFirst()
    {
        Iterator it = iterator();
        if (!it.hasNext()) {
            return null;
        } else {
            return (it.next());
        }
    }

    // Object vooraan verwijderen
    public Object removeFirst()
    {
        Object tmp = header.next.element;
        remove(header.next);
        return tmp;
    }

    @Override public void addLast(Object element)
    {
        add(header.previous, element, header);
    }

    @Override public Object getLast()
    {
        Iterator it = iterator();
        if (!it.hasPrevious()) {
            return null;
        } else {
            return (it.previous());
        }
    }

    @Override public Object removeLast()
    {
        Object tmp = header.previous.element;
        remove(header.previous);
        return tmp;
    }

    // Aantal objecten in de lijst afleveren
    public int size()
    {
        return size;
    }

    // De lijst leegmaken
    public void clear()
    {
        header.next = header;
        header.previous = header;
        size = 0;
    }

    // Lever een iterator voor de lijst
    public Iterator iterator()
    {
        return new LItr();
    }

    // private methoden
    private void add(Entry previous, Object element, Entry next )
    {
        Entry newEntry = new Entry(previous, element, next);
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        size++;
    }

    private void remove( Entry element )
    {
        if( element == header )
            throw new NoSuchElementException(
                "Kan Entry niet verwijderen: is header" );

        element.previous.next = element.next;
        element.next.previous = element.previous;
        size--;
    }

    // Inwendige klasse LItr
    private class LItr implements Iterator
    {
        private Entry pos = header;

        public boolean hasNext()
        {
            return pos.next != header;
        }

        public Object next()
        {
            pos = pos.next;
            return pos.element;
        }

        public boolean hasPrevious()
        {
            return pos.previous != header;
        }

        public Object previous()
        {
            pos = pos.previous;
            return pos.element;
        }
    } // Einde inwendige klasse LItr

} // Einde klasse LijstImpl
