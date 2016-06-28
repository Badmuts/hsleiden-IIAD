package nl.daanrosbergen.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListUnitTest {
    Lijst list;

    @Before public void setUp() throws Exception {
        list = new LijstImpl();
        list.addFirst( "Drie" );
        list.addFirst( "Twee" );
        list.addFirst( "Een" );
        list.addLast( "Vier" );
        list.addLast( "Vijf" );
        list.addLast( "Zes" );
    }

    @Test public void shouldAddItemsToBegin() throws Exception {
        Lijst lijst = new LijstImpl();

        lijst.addFirst( "Drie" );
        lijst.addFirst( "Twee" );
        lijst.addFirst( "Een" );

        Assert.assertEquals(lijst.getFirst(), "Een");
    }

    @Test public void shouldAddItemsToEnd() throws Exception {
        Lijst lijst = new LijstImpl();

        lijst.addLast( "Vier" );
        lijst.addLast( "Vijf" );
        lijst.addLast( "Zes" );

        Assert.assertEquals(lijst.getLast(), "Zes");
    }

    @Test public void shouldGetFirst() throws Exception {
        Assert.assertEquals(list.getFirst(), "Een");
    }

    @Test public void shouldGetLast() throws Exception {
        Assert.assertEquals(list.getLast(), "Zes");
    }

    @Test public void shouldRemoveFirst() throws Exception {
        list.removeFirst();
        Assert.assertEquals(list.getFirst(), "Twee");
    }

    @Test public void shouldRemoveLast() throws Exception {
        list.removeLast();
        Assert.assertEquals(list.getLast(), "Vijf");
    }
}
