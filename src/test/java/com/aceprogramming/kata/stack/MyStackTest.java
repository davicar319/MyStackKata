package com.aceprogramming.kata.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTest {

    @Test
    void aNewlyCreatedStackIsEmpty() {
        var stack = new MyStack();
        Assertions.assertTrue(stack.isEmpty());
    }
}
