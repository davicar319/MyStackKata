package com.aceprogramming.kata.stack;

public final class MyStackFactory<T> {

    MyStack<T> createStack(int maxSize) {
        return new BoundedMyStack<>(maxSize);
    }

    MyStack<T> createStack() {
        return new UnboundedMyStack<>();
    }
}
