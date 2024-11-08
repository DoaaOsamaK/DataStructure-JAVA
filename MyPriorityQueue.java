package datastructure;

import java.util.*;

public class MyPriorityQueue<T> {

    private List<T> queue;
    private Comparator<? super T> comparator;

    // Constructor: Initializes the priority queue with a default comparator
    public MyPriorityQueue() {
        this.queue = new ArrayList<>();
        this.comparator = null;
    }

    // Constructor with custom comparator
    public MyPriorityQueue(Comparator<? super T> comparator) {
        this.queue = new ArrayList<>();
        this.comparator = comparator;
    }

    // Adds an element to the priority queue
    public void add(T val) {
        queue.add(val);
        Collections.sort(queue, comparator);
    }

    // Removes and returns the highest priority element
    public T remove() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return queue.remove(0);
    }

    // Returns the highest priority element without removing it
    public T peek() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return queue.get(0);
    }

    // Returns the size of the queue
    public int size() {
        return queue.size();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Clears the queue
    public void clear() {
        queue.clear();
    }

    // Returns the string representation of the priority queue
    @Override
    public String toString() {
        return queue.toString();
    }
}
