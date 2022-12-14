package lab3;

import java.util.Arrays;


public class SimpleList<T> implements CustomList<T> {
    private final static Object[] EMPTY = {};
    private Object[] array;
    private int size;


    public SimpleList(Object[] a) {
        if ((size = a.length) != 0) {
            array = Arrays.copyOf(a, size, Object[].class);
        } else {
            array = EMPTY;
        }
    }


    public SimpleList() {
        this.array = EMPTY;
        this.size = 0;
    }

    public SimpleList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.array = EMPTY;
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                initialCapacity);
        }
    }


    @Override
    public void add(T element) {
        increaseArrayIfReqire();
        array[size] = element;
        size++;
    }


    private void increaseArrayIfReqire() {
        if (size == array.length) {
            increaseArray();
        }
    }


    private void validateArrayIndex(int index) {
        if (size <= index)
            throw new IndexOutOfBoundsException("Переданный 'индекс' вышел из предела массива " + (size - 1));
    }


    private void increaseArray(int newCapacity) {
        array = allocateArray(calculateNewCapacity(newCapacity));
    }


    private void increaseArray() {
        increaseArray(size + 1);
    }


    private Object[] allocateArray(int newSize) {
        final Object[] newArray = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }


    private int calculateNewCapacity(Integer capacity) {
        return capacity == null
            ? (int) (size * 1.25)
            : size + capacity;
    }


    @Override
    public void insert(int index, T element) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }


    @Override
    public T get(int index) {
        validateArrayIndex(index);
        return (T) array[index];
    }


    @Override
    public T remove(int index) {
        validateArrayIndex(index);
        var existsElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return (T) existsElement;
    }


    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        var stb = new StringBuilder();
        stb.append("[ ");

        for (int i = 0; i < size; i++) {
            stb.append(array[i]);
            if (i != size - 1 ){
                stb.append(", ");
            }
        }

        stb.append(" ]");

        return stb.toString();
    }


    @Override
    public void clear() {
        array = EMPTY;
        size = 0;
    }


    public CustomList<T> copy() {
        var obj = new Object[size];
        for (int i = 0; i < size; i++) {
            obj[i] = array[i];
        }

        return new SimpleList<T>(obj);
    }
}
