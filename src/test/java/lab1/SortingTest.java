package lab1;

import java.util.Arrays;
import lab2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SortingTest {
    private static int[] UNSORTED_ARRAY;


    @BeforeEach
    void setupArray() {
        UNSORTED_ARRAY = new int[]{ 20, 35, -15, 7, 55, 1, -22 };
    }


    @Test
    void testBubbleSort() {
        var copy = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
        BubbleSort.sort(copy);

        Arrays.sort(UNSORTED_ARRAY);

        Assertions.assertArrayEquals(UNSORTED_ARRAY, copy);
    }


    @Test
    void testInsertionSort() {
        var copy = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
        InsertingSort.sort(copy);

        Arrays.sort(UNSORTED_ARRAY);

        Assertions.assertArrayEquals(UNSORTED_ARRAY, copy);
    }


    @Test
    void testSelectionSort() {
        var copy = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
        SelectionSort.sort(copy);

        Arrays.sort(UNSORTED_ARRAY);

        Assertions.assertArrayEquals(UNSORTED_ARRAY, copy);
    }


    @Test
    void testMergeSort() {
        var copy = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
        MergeSort.sort(copy);

        Arrays.sort(UNSORTED_ARRAY);

        Assertions.assertArrayEquals(UNSORTED_ARRAY, copy);
    }



    @Test
    void testQuickSort() {
        var copy = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
        QuickSort.sort(copy);

        Arrays.sort(UNSORTED_ARRAY);

        Assertions.assertArrayEquals(UNSORTED_ARRAY, copy);
    }
}
