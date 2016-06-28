package nl.daanrosbergen.bubblesort;

import nl.daanrosbergen.mergesort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Daanr on 28-Jun-16.
 */
public class BubbleSortUnitTest {
    char[] unordedList = {'M', 'B', 'D', 'A', 'K'};
    char[] ordedList = {'A', 'B', 'D', 'K', 'M'};

    @Test
    public void shouldSort() throws Exception {
        BubbleSort.sort(unordedList);
        Assert.assertArrayEquals(unordedList, ordedList);
    }
}
