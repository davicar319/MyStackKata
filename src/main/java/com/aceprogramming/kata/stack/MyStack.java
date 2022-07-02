package com.aceprogramming.kata.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyStack<T> {
    private final List<T> backingStore;

    public MyStack() {
        backingStore = new ArrayList<>();
    }

    public boolean isEmpty() {
        return backingStore.isEmpty();
    }

    public void push(T i) {
        backingStore.add(i);
    }

    public T pop() {
        try {
            return backingStore.remove(topElement());
        } catch(IndexOutOfBoundsException e) {
            throw new Underflow(e);
        }
    }

    public Optional<T> top() {
        return backingStore.isEmpty() ? Optional.empty() : Optional.of(backingStore.get(topElement()));
    }

    private int topElement() {
        return backingStore.size() - 1;
    }

    public static class Underflow extends RuntimeException {
        Underflow(Throwable e) {
            super(e);
        }
    }
}
