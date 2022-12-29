package lab3;

import lab3.DoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DoubleLinkedListTest {
    @Test
    void testAdd() {
        var list = new DoubleLinkedList<Integer>();
        list.add(1);
        list.add(5);
        list.add(9);

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(5, list.get(1));
        Assertions.assertEquals(9, list.get(2));
    }


    @Test
    void testInsert() {
        var list = new DoubleLinkedList<Integer>();
        list.add(23);
        list.add(12);
        list.add(55);


        list.insert(0, 44);
        list.insert(1, 17);
        list.insert(4, 33);

        Assertions.assertEquals(44, list.get(0));
        Assertions.assertEquals(17, list.get(1));
        Assertions.assertEquals(23, list.get(2));
        Assertions.assertEquals(33, list.get(4));

        Assertions.assertEquals(6, list.size());
    }


    @Test
    void testRemove() {
        var list = new DoubleLinkedList<Integer>();
        list.add(23);
        list.add(12);
        list.add(55);
        list.add(44);
        list.add(17);
        list.add(33);

        list.remove((Integer) 33);
        Assertions.assertEquals(17, list.get(4));

        list.remove((Integer) 23);
        Assertions.assertEquals(12, list.get(0));

        list.remove((Integer) 44);
        Assertions.assertEquals(17, list.get(2));
        Assertions.assertEquals(55, list.get(1));

        Assertions.assertEquals(3, list.size());
    }


    @Test
    void testCopy() {
        var list = new DoubleLinkedList<Integer>();
        list.add(23);
        list.add(12);

        var copy = list.copy();

        Assertions.assertEquals(list.get(0), copy.get(0));
        Assertions.assertEquals(list.get(0), copy.get(1));
    }
}
