package lab3;

import lombok.Setter;


public class CircleLinkedList<T> implements CustomList<T> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        tail.next = head;
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

        var nextNode = getNode(index);
        var currentNode = new Node(nextNode, element);

        if (index != 0) {
            var previousNode = getNode(index - 1);
            previousNode.setNext(currentNode);
        } else {
            head = currentNode;
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

        Node nodePrevious;

        if (index == 0) {
            head = nodeNext;
        }

        if (index == size) {
            nodePrevious = getNode(index - 1);
            nodePrevious.setNext(nodeNext);
            tail = nodePrevious;
        }

        if (index != 0 && index != size) {
            nodePrevious = getNode(index - 1);
            nodePrevious.setNext(nodeNext);
        }

        size--;
        return true;
    }

    @Override
    public String toString() {
        var node = head;
        var stb = new StringBuilder();
        while (node != null) {
            stb.append(node.value);
            node = node.next;
            if (node != null) {
                stb.append("->");
            }
        }
        return stb.toString();
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
        var list = new CircleLinkedList<T>();
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


    @Setter
    class Node {

        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}
