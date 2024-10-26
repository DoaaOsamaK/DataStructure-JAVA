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

     public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = elements[--size];
        elements[size] = null;
        return value;
    }

}
