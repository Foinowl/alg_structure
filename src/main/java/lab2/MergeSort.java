package lab2;

import utils.CollectionUtils;


public class MergeSort {

    public static void sort(int[] source) {
        if (CollectionUtils.isEmpty(source)) {
            return;
        }

        mergeSort(source, 0, source.length);
    }


    private static void mergeSort(int[] source, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(source, start, mid);
        mergeSort(source, mid, end);
        merge(source, start, mid, end);
    }


    private static void merge(int[] source, int start, int mid, int end) {

        if (source[mid - 1] <= source[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = source[i] <= source[j] ? source[i++] : source[j++];
        }

        System.arraycopy(source, i, source, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, source, start, tempIndex);
    }
}
