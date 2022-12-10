package lab2;

public class InsertingSort {
    public static void sort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            int element = source[i];

            int j;

            for (j = i; j > 0 && source[j - 1] > element; j--) {
                source[j] = source[j - 1];
            }

            source[j] = element;
        }
    }
}
