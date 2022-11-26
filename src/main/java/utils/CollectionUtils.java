package utils;

import java.util.Collection;


public class CollectionUtils {
    public static boolean isEmpty(Collection<?> source) {
        return source == null || source.isEmpty();
    }
}
