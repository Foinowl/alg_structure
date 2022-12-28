package lab3;

public class SimpleQueue<T> implements CustomQueue<T> {
    private final CustomList<T> list;


    public SimpleQueue(Object[] a) {
        this.list = new SimpleList<>(a);
    }

    public SimpleQueue() {
        this.list = new SimpleList<>();
    }

    @Override
    public void push(T element) {
        list.insert(0, element);
    }


    @Override
    public T peek() {
        return list.get(size() - 1);
    }


    @Override
    public T pop() {
        return list.delete(size() - 1);
    }


    @Override
    public CustomQueue<T> clone() {
        return new SimpleQueue<>(list.clone());
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
