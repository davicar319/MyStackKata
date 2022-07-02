package com.aceprogramming.kata.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTest {

    private final MyStack<Integer> stack = new UnboundedMyStack<>();

    @Test
    void aNewlyCreatedStackIsEmpty() {
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void whenStackIsPushedItIsNoLongerEmpty() {
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void whenStackIsPushedAndPoppedItIsEmpty() {
        stack.push(1);
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void whenStackIsPoppedTheLastItemPushedIsReturned() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
    }

    @Test
    void poppingAnEmptyStackThrowsAnException() {
        Assertions.assertThrows(UnboundedMyStack.Underflow.class, stack::pop);
    }

    @Test
    void theTopOfAnEmptyStackIsEmpty() {
        Assertions.assertTrue(stack.top().isEmpty());
    }

    @Test
    void theTopOfAnEmptyStackIsTheLastThingPushed() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.top().orElseThrow());
    }

}
