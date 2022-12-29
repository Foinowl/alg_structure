package lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class SingleLinkedList<T> implements CustomList<T> {

    private Node head;
    private Node tail;
    private Integer size;


    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        if (head == null) {
            head = new Node(null, element);
            tail = head;
            head.setNext(tail);
            size++;
            return;
        }

        var currentNode = tail;
        tail = new Node(null, element);
        currentNode.setNext(tail);
        size++;
    }


    @Override
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            add(element);
            return;
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
        return getNode(index).getValue();
    }

    @Override
    public T remove(int index) {
        var node = getNode(index);
        removeAt(index);
        return node.getValue();
    }

    @Override
    public boolean remove(T element) {
        int index = searchElement(element);
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

        if (nodeNext == null) {
            nodePrevious = getNode(index - 1);
            nodePrevious.setNext(null);
            tail = nodePrevious;
        }

        if (index != 0 && nodeNext != null) {
            nodePrevious = getNode(index - 1);
            nodePrevious.setNext(nodeNext);
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
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public CustomList<T> copy() {
        var clone = new SingleLinkedList<T>();
        var node = head;
        for (int i = 0; i < size; i++) {
            clone.add(node.value);
        }

        return clone;
    }


    private int searchElement(T element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(element)) {
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


    @AllArgsConstructor
    @Setter
    @Getter
    private class Node {
        private Node next;
        private T value;
    }
}
