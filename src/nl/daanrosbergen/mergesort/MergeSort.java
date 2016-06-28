package nl.daanrosbergen.mergesort;

/**
 * Worst case: O(n log n).
 * Best case: O(n).
 */
public class MergeSort {

    public static void sort(char[] list) {
        if (list.length > 1) {

            char[] left = new char[list.length / 2];
            System.arraycopy(list, 0, left, 0, list.length / 2);
            sort(left);

            int rightLength = list.length - list.length / 2;
            char[] right = new char[rightLength];
            System.arraycopy(list, list.length / 2, right, 0, rightLength);
            sort(right);

            char[] temp = merge(left, right); //runs n times
            System.arraycopy(temp, 0, list, 0, temp.length); //runs n times

        }
    }

    private static char[] merge(char[] left, char[] right) {
        char[] temp = new char[left.length + right.length];

        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        //Loop the elements
        while (current1 < left.length && current2 < right.length) { //Runs n - 1
            //Compare the elements in each list and add to the merge list
            if (left[current1] < right[current2])
                temp[current3++] = left[current1++];
            else
                temp[current3++] = right[current2++];
        }
        //Copy the rest of elements into the list
        while (current1 < left.length)
            temp[current3++] = left[current1++];
        //Copy the rest of elements into the list
        while (current2 < right.length)
            temp[current3++] = right[current2++];

        return temp;
    }

}
