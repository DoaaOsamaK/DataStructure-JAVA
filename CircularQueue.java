public class CircularQueue<T> {

    private final T[] arr;
    private int front, rear;
    private final int size;

    public CircularQueue(int capacity) {
        this.size = capacity;
        arr = (T[]) new Object[capacity];
        front = rear = -1;
    }

    /**
     * Adds an element to the rear of the queue.
     */
    public void enqueue(T val) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = val;
    }

    /**
     * Removes and returns the element at the front of the queue.
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T val = arr[front];
        if (rear == front) { // Queue is empty after dequeue
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    /**
     * Returns the element at the rear of the queue without removing it.
     */
    public T rear() {
        return isEmpty() ? null : arr[rear];
    }

    /**
     * Returns the element at the front of the queue without removing it.
     */
    public T front() {
        return isEmpty() ? null : arr[front];
    }

    /**
     * Checks if the queue is empty.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the queue is full.
     */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("[");
        for (int i = front;; i = (i + 1) % size) {
            s.append(arr[i]);
            if (i == rear) {
                break;
            }
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}
