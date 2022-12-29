package lab1;

import lab3.SimpleStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SimpleStackTest {


    @Test
    void testPushToStack() {
        var stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, 3);
    }


    @Test
    void testPopElements() {
        var stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.size());

        stack.push(5);
        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.size());
    }


    @Test
    void testPeek() {
        var stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.peek());
        Assertions.assertEquals(3, stack.size());
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
        var stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        var cloneStack = stack.copy();
        Assertions.assertEquals(stack.size(), cloneStack.size());

        Assertions.assertEquals(stack.pop(), cloneStack.pop());
        Assertions.assertEquals(stack.pop(), cloneStack.pop());
        Assertions.assertEquals(stack.pop(), cloneStack.pop());

        Assertions.assertEquals(0, stack.size());
        Assertions.assertEquals(0, cloneStack.size());

    }
}
