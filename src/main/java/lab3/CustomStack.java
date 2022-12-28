package lab3;

public class CustomStack<T> implements Stack<T> {
    private final CustomList<T> list;

    public CustomStack(Object[] a) {
        this.list = new SimpleList<>(a);
    }


    @Override
    public void push(T element) {
        list.add(element);
    }


    @Override
    public T pop() {
        return list.delete(list.size());
    }


    @Override
    public Stack<T> clone() {
        return new CustomStack<>(list.clone());
    }


    @Override
    public void clear() {
        list.clear();
    }
}
