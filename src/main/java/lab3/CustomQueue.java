package lab3;

public interface CustomQueue<T> {
    void push(T element);

    T peek();

    T pop();

    CustomQueue<T> copy();

    void clear();

    int size();
}