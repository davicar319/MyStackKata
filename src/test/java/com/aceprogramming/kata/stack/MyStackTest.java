package com.aceprogramming.kata.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MyStackTest {

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void aNewlyCreatedStackIsEmpty(MyStack<Integer> myStack) {
        Assertions.assertTrue(myStack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void whenStackIsPushedItIsNoLongerEmpty(MyStack<Integer> myStack) {
        myStack.push(1);
        Assertions.assertFalse(myStack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void whenStackIsPushedAndPoppedItIsEmpty(MyStack<Integer> myStack) {
        myStack.push(1);
        myStack.pop();
        Assertions.assertTrue(myStack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void whenStackIsPoppedTheLastItemPushedIsReturned(MyStack<Integer> myStack) {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        Assertions.assertEquals(3, myStack.pop());
        Assertions.assertEquals(2, myStack.pop());
        Assertions.assertEquals(1, myStack.pop());
    }

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void poppingAnEmptyStackThrowsAnException(MyStack<Integer> myStack) {
        Assertions.assertThrows(MyStack.Underflow.class, myStack::pop);
    }

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void theTopOfAnEmptyStackIsEmpty(MyStack<Integer> myStack) {
        Assertions.assertTrue(myStack.top().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("unboundedAndBoundedEmptyStackArguments")
    void theTopOfAnEmptyStackIsTheLastThingPushed(MyStack<Integer> myStack) {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        Assertions.assertEquals(3, myStack.top().orElseThrow());
    }

    private static Stream<Arguments> unboundedAndBoundedEmptyStackArguments() {
        return Stream.of(
                Arguments.of(new UnboundedMyStack<Integer>()),
                Arguments.of(new BoundedMyStack<Integer>(3))
        );
    }
}
