package lab1;

import lab3.SimpleList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SimpleListTest {


    @Test
    void testSizeList() {
        var list1 = new SimpleList<>();
        Assertions.assertEquals(0, list1.size());

        var list2 = new SimpleList<>(10);
        Assertions.assertEquals(10, list2.size());
    }

    @Test
    void testAddElementsWithDefaultLength() {
        var list = new SimpleList<>(4);
        list.add(1);
        list.add(5);
        list.add(15);
        list.add(20);
        list.add(70);
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(5, list.get(1));
        Assertions.assertEquals(15, list.get(2));
        Assertions.assertEquals(20, list.get(3));
        Assertions.assertEquals(70, list.get(4));
    }

    @Test
    void testAddElementsWithEmpty() {
        var list = new SimpleList<>();
        list.add(122);
        list.add(555);
        list.add(228);
        Assertions.assertEquals(122, list.get(0));
        Assertions.assertEquals(555, list.get(1));
        Assertions.assertEquals(228, list.get(2));
    }


    @Test
    void testInsertElements() {
        var list = new SimpleList<>();
        list.add(122);
        list.add(555);
        list.add(228);

        Assertions.assertEquals(3, list.size());

        list.insert(1, 444);
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(444, list.get(1));
        Assertions.assertEquals(555, list.get(2));
    }


    @Test
    void testClear() {
        var list = new SimpleList<>();
        list.add(122);
        list.add(555);
        list.add(228);

        list.clear();
        Assertions.assertEquals(0, list.size());
    }


    @Test
    void testDelete() {
        var list = new SimpleList<>();
        list.add(122);
        list.add(555);
        list.add(228);

        list.remove((Integer)555);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testPrint() {
        var list = new SimpleList<>();
        list.add(122);
        list.add(555);
        list.add(228);

        System.out.println(list);
    }
}
