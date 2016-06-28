package nl.daanrosbergen;

import nl.daanrosbergen.bubblesort.BubbleSort;
import nl.daanrosbergen.mergesort.MergeSort;

public class Main {

    public static void main(String[] args) {
        char[] bubble = {'M', 'B', 'D', 'A', 'K'};
        System.out.println(bubble);
        BubbleSort.sort(bubble);
        System.out.println(bubble);

        char[] merge = {'M', 'B', 'D', 'A', 'K'};
        System.out.println(merge);
        MergeSort.sort(merge);
        System.out.println(merge);
    }
}
