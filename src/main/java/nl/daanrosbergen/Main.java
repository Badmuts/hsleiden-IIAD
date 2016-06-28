package nl.daanrosbergen;

import nl.daanrosbergen.bubblesort.BubbleSort;
import nl.daanrosbergen.linkedlist.Iterator;
import nl.daanrosbergen.linkedlist.Lijst;
import nl.daanrosbergen.linkedlist.LijstImpl;
import nl.daanrosbergen.mergesort.MergeSort;

public class Main {

    public static void main(String[] args) {
        testBubbleSort();
        testMergeSort();
        testDoubleLinkedList();
    }

    private static void testBubbleSort() {
        char[] bubble = {'M', 'B', 'D', 'A', 'K'};
        System.out.println(bubble);
        BubbleSort.sort(bubble);
        System.out.println(bubble);
    }

    private static void testMergeSort() {
        char[] merge = {'M', 'B', 'D', 'A', 'K'};
        System.out.println(merge);
        MergeSort.sort(merge);
        System.out.println(merge);
    }

    private static void testDoubleLinkedList() {
        Lijst lijst = new LijstImpl();

        lijst.addFirst( "Drie" );
        lijst.addFirst( "Twee" );
        lijst.addFirst( "Een" );

        lijst.addLast( "Vier" );
        lijst.addLast( "Vijf" );
        lijst.addLast( "Zes" );

        System.out.println("getFirst: " + lijst.getFirst());
        System.out.println("getLast: " + lijst.getLast());
        System.out.println(lijst.removeFirst() + " is verwijderd [removeFirst]");
        System.out.println(lijst.removeLast() + " is verwijderd [removeLast]");

        Iterator iter = lijst.iterator();

        while( iter.hasNext() )
            System.out.println( iter.next() );

        System.out.println("\n En nu omgekeerd : \n");

        iter = lijst.iterator();
        while( iter.hasPrevious() )
            System.out.println( iter.previous() );
    }
}
