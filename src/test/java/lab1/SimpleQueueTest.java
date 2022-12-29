package lab1;


import lab3.SimpleQueue;
import lab3.SimpleStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SimpleQueueTest {


    @Test
    void testPushToQueue() {
        var queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assertions.assertEquals(3, 3);
    }


    @Test
    void testPopElements() {
        var queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assertions.assertEquals(1, queue.pop());
        Assertions.assertEquals(2, queue.size());

        queue.push(5);
        Assertions.assertEquals(2, queue.pop());
        Assertions.assertEquals(3, queue.pop());
        Assertions.assertEquals(5, queue.pop());
    }


    @Test
    void testPeek() {
        var queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(3, queue.size());
    }


    @Test
    void testClear() {
        var stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.clear();
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    void testCopyStack() {
        var queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        var queueClone = queue.copy();
        Assertions.assertEquals(queue.size(), queueClone.size());

        Assertions.assertEquals(queue.pop(), queueClone.pop());
        Assertions.assertEquals(queue.pop(), queueClone.pop());
        Assertions.assertEquals(queue.pop(), queueClone.pop());

        Assertions.assertEquals(0, queue.size());
        Assertions.assertEquals(0, queueClone.size());
    }
}
