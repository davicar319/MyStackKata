package com.aceprogramming.kata.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class UnboundedMyStack<T> implements MyStack<T> {
    private final List<T> backingStore;

    public UnboundedMyStack() {
        backingStore = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return backingStore.isEmpty();
    }

    @Override
    public void push(T i) {
        backingStore.add(i);
    }

    @Override
    public T pop() {
        try {
            return backingStore.remove(topElement());
        } catch(IndexOutOfBoundsException e) {
            throw new Underflow(e);
        }
    }

    @Override
    public Optional<T> top() {
        return backingStore.isEmpty() ? Optional.empty() : Optional.of(backingStore.get(topElement()));
    }

    private int topElement() {
        return backingStore.size() - 1;
    }

}
