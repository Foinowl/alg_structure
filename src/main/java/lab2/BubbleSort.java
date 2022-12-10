package lab2;

public class BubbleSort {
    public static void sort(int[] source) {
        for (int i = 0; i < source.length; i++)
            for (int j = i; j > 0 &&
                source[j - 1] > source[j]; j--)
                ArraysUtil.swap(source, j, j - 1);
    }
}
