package lab2;

import utils.CollectionUtils;


public class QuickSort {

    public static void sort(int[] source) {
        if (CollectionUtils.isEmpty(source)) {
            return;
        }

        quickSort(source, 0, source.length);
    }


    public static void quickSort(int[] source, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(source, start, end);
        quickSort(source, start, pivotIndex);
        for (int i = 0; i < source.length; i++) {
            System.out.println(source[i]);
        }
        quickSort(source, pivotIndex + 1, end);
    }

    public static int partition(int[] source, int start, int end) {
        // This is using the first element as the pivot
        int pivot = source[start];
        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && source[--j] >= pivot);
            if (i < j) {
                source[i] = source[j];
            }

            while (i < j && source[++i] <= pivot);
            if (i < j) {
                source[j] = source[i];
            }

        }

        source[j] = pivot;
        return j;

    }
}
