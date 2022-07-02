package com.aceprogramming.kata.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private final List<Integer> backingStore;

    public MyStack() {
        backingStore = new ArrayList<>();
    }

    public boolean isEmpty() {
        return backingStore.isEmpty();
    }

    public void push(int i) {
        backingStore.add(i);
    }

    public int pop() {
        try {
            return backingStore.remove(backingStore.size() - 1);
        } catch(IndexOutOfBoundsException e) {
            throw new Underflow(e);
        }
    }

    public static class Underflow extends RuntimeException {
        Underflow(Throwable e) {
            super(e);
        }
    }
}
