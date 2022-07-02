package com.aceprogramming.kata.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnboundedMyStackTest {

    @Test
    void pushThrowsOverflowWhenTooManyPushed() {
        MyStack<String> boundedStringStack = new BoundedMyStack<>(3);
        boundedStringStack.push("Test 1");
        boundedStringStack.push("Test 2");
        boundedStringStack.push("Test 3");
        Assertions.assertThrows(MyStack.Overflow.class,
                () -> boundedStringStack.push("Boom"));
    }
}