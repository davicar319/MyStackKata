package com.aceprogramming.kata.stack;

import java.util.Optional;

public class BoundedMyStack<T> implements MyStack<T> {
    private final int maximumSize;
    private int currentIndex;
    private final UnboundedMyStack<T> backingStore;

    public BoundedMyStack(int maximumSize) {
        this.maximumSize = maximumSize;
        this.backingStore = new UnboundedMyStack<>();
        this.currentIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return backingStore.isEmpty();
    }

    @Override
    public void push(T i) {
        if(currentIndex < maximumSize) {
            doPush(i);
        } else {
            throw new Overflow();
        }
    }

    private void doPush(T i) {
        backingStore.push(i);
        ++currentIndex;
    }

    @Override
    public T pop() {
        return backingStore.pop();
    }

    @Override
    public Optional<T> top() {
        return backingStore.top();
    }
}
