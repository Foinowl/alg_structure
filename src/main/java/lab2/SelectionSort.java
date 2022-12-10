package lab2;

public class SelectionSort {
    public static void sort(int[] source) {
        for (int i = source.length - 1; i > 0; i--) {
            int largest = 0;

            for (int j = 1; j <= i; j++) {
                if (source[j] > source[largest]) {
                    largest = j;
                }
            }

            ArraysUtil.swap(source, largest, i);

        }
    }
}
