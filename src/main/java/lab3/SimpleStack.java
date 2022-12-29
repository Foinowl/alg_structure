package lab3;

public class SimpleStack<T> implements CustomQueue<T> {
    private final CustomList<T> list;


    public SimpleStack(Object[] a) {
        this.list = new SimpleList<>(a);
    }

    public SimpleStack(CustomList<T> list) {
        this.list = list;
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
        return list.remove(list.size() - 1);
    }


    @Override
    public CustomQueue<T> copy() {
        return new SimpleStack<>(list.copy());
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
