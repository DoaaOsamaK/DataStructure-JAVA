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

     public void push(T value) {
        ensureCapacity();
        elements[size++] = value;
    }

     @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
