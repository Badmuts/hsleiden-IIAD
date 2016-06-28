package nl.daanrosbergen.bubblesort;

/**
 * Worst case: O(n^2).
 * Best case: O(1).
 */
public class BubbleSort {

    public static void sort(char[] list) {
        int   n    = list.length;
        char  t;

        // Loop through arrayToSort.
        for (int c = 0; c < (n - 1); c++) {
            // Loop only through length of array of unsorted items.
            for (int d = 0; d < n - c - 1; d++) {
                // Is left value greater then right value?
                if (list[d] > list[d+1]) { // Time to swap
                    t                = list[d];   // save left
                    list[d]   = list[d+1]; // left = right
                    list[d+1] = t;                // right = left
                }
            }
        }
    }

}
