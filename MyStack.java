package datastructure;

import java.util.EmptyStackException;
import java.util.Arrays;

public class MyStack<T> {

    private static final int INITIAL_CAPACITY = 5;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MyStack() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
