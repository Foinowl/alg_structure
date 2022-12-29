package lab3;

public class DoubleLinkedList<T> implements CustomList<T> {

    private Node head;
    private Node tail;
    private int size = 0;


    @Override
    public void add(T element) {
        if (size == 0) {
            head = new Node(null, element, null);
            tail = head;
        } else {
            Node previousNode = tail;
            tail = new Node(previousNode, element, null);
            previousNode.next = tail;
        }
        size++;
    }

    @Override
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, element, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T remove(int index) {
        var node = getNode(index);
        removeAt(index);
        return node.value;
    }

    @Override
    public boolean remove(T element) {
        int index = findElement(element);
        if (index != -1) {
            return removeAt(index);
        }
        return false;
    }

    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            tail = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            head = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public void print() {

    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public CustomList<T> copy() {
        var list = new DoubleLinkedList<T>();
        var node = head;
        for (int i = 0; i < size; i++) {
            list.add(node.value);
        }

        return list;
    }

    private int findElement(T car) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    private class Node {
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
