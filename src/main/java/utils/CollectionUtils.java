package utils;

import java.util.Collection;


public class CollectionUtils {
    public static boolean isEmpty(Collection<?> source) {
        return source == null || source.isEmpty();
    }


    public static boolean isEmpty(int[] source) {
        return source == null || source.length == 0;
    }


    public static boolean isEmpty(double[] source) {
        return source == null || source.length == 0;
    }
}
