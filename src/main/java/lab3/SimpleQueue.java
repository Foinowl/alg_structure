package lab3;

public class SimpleQueue<T> implements CustomQueue<T> {
    private final CustomList<T> list;


    public SimpleQueue(Object[] a) {
        this.list = new SimpleList<>(a);
    }

    public SimpleQueue(CustomList<T> list) {
        this.list = list;
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
        return list.remove(size() - 1);
    }


    @Override
    public CustomQueue<T> copy() {
        return new SimpleQueue<>(list.copy());
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
