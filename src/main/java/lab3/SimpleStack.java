package lab3;

public class SimpleStack<T> implements CustomQueue<T> {
    private final CustomList<T> list;


    public SimpleStack(Object[] a) {
        this.list = new SimpleList<>(a);
    }

    public SimpleStack() {
        this.list = new SimpleList<>();
    }


    @Override
    public void push(T element) {
        list.add(element);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }


    @Override
    public T pop() {
        return list.delete(list.size() - 1);
    }


    @Override
    public CustomQueue<T> clone() {
        return new SimpleStack<>(list.clone());
    }


    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }
}
