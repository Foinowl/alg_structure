package lab3;

public interface Stack<T> {

    void push(T element);

    T pop();

    Stack<T> clone();

    void clear();
}
