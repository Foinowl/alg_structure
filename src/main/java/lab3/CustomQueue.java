package lab3;

public interface CustomQueue<T> {
    void push(T element);

    T peek();

    T pop();

    CustomQueue<T> clone();

    void clear();

    int size();
}