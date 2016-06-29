package nl.daanrosbergen;

import nl.daanrosbergen.bubblesort.BubbleSort;
import nl.daanrosbergen.linkedlist.Iterator;
import nl.daanrosbergen.linkedlist.Lijst;
import nl.daanrosbergen.linkedlist.LijstImpl;
import nl.daanrosbergen.mergesort.MergeSort;
import nl.daanrosbergen.stack.Calculator;
import nl.daanrosbergen.tree.Node;

public class Main {

    public static void main(String[] args) {
        testBubbleSort();
        testMergeSort();
        testDoubleLinkedList();
        testCalculator();
        testTree();
    }

    private static void testTree() {
        System.out.println("======");
        System.out.println("TREE");
        System.out.println("======");
        Node<String> aap = new Node<String>("aap");

        Node<String> noot = new Node<String>("noot");
        Node<String> mies = new Node<String>("mies");
        aap.add(noot);
        aap.add(mies);
        noot.add(new Node<String>("Wim"));
        noot.add(new Node<String>("Jet"));

        System.out.print("PRE : ");
        aap.printPreOrder(aap);
        System.out.print("\nPOST: ");
        aap.printPostOrder(aap);
        System.out.print("\nIN  : ");
        aap.printInOrder(aap);

        System.out.print("\nDiepte: " + Node.diepte(aap));
        System.out.print("\nAantal knopen: " + aap.aantalKnopen());
        System.out.print("\nTree: \n");
        aap.printTree();
    }

    private static void testCalculator() {
        System.out.println("======");
        System.out.println("CALC");
        System.out.println("======");
        Calculator calculator = new Calculator("3 4 5 3 + * /");
        System.out.println("Calc result: " + calculator.getResultaat());
    }

    private static void testBubbleSort() {
        System.out.println("======");
        System.out.println("BUBBLE");
        System.out.println("======");
        char[] bubble = {'M', 'B', 'D', 'A', 'K'};
        System.out.println(bubble);
        BubbleSort.sort(bubble);
        System.out.println(bubble);
    }

    private static void testMergeSort() {
        System.out.println("======");
        System.out.println("MERGE");
        System.out.println("======");
        char[] merge = {'M', 'B', 'D', 'A', 'K'};
        System.out.println(merge);
        MergeSort.sort(merge);
        System.out.println(merge);
    }

    private static void testDoubleLinkedList() {
        System.out.println("======");
        System.out.println("LINKED LIST");
        System.out.println("======");
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
