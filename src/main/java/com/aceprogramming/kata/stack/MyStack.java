package com.aceprogramming.kata.stack;

import java.util.Optional;

public interface MyStack<T> {
    boolean isEmpty();

    void push(T i);

    T pop();

    Optional<T> top();

    class Underflow extends RuntimeException {
        Underflow(Throwable e) {
            super(e);
        }
    }
}
