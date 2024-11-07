import java.util.ArrayList;

class QueueArrayList<T> {
    private ArrayList<T> queue;

    // Constructor
    public QueueArrayList() {
        this.queue = new ArrayList<>();
    }

    // Enqueue method - adds an element to the end of the queue
    public void enqueue(T element) {
        queue.add(element);
    }

    // Dequeue method - removes the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.remove(0);
    }

    // Peek method - returns the front element without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.get(0);
    }

    // isEmpty method - checks if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Size method - returns the number of elements in the queue
    public int size() {
        return queue.size();
    }
}
