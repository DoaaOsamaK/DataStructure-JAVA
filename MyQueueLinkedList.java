package datastructureclasses;

public class MyQueueLinkedList<T> {
    private Node<T> front, rear;
    private int size;

    // Node class to represent each element in the queue
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public MyQueueLinkedList() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Offer method - Adds an item to the end of the queue
    public boolean offer(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    // Peek method - Returns the front element without removing it
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    // Poll method - Removes and returns the front element of the queue
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Queue is now empty
        }
        size--;
        return item;
    }

    // isEmpty method - Checks if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Size method - Returns the number of elements in the queue
    public int size() {
        return size;
    }

    // toString method - Returns a string representation of the queue
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
