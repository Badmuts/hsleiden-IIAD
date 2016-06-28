package nl.daanrosbergen.mergesort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Daanr on 28-Jun-16.
 */
public class MergeSortUnitTest {

    char[] unordedList = {'M', 'B', 'D', 'A', 'K'};
    char[] ordedList = {'A', 'B', 'D', 'K', 'M'};

    @Test
    public void shouldSort() throws Exception {
        MergeSort.sort(unordedList);
        Assert.assertArrayEquals(unordedList, ordedList);
    }

}
