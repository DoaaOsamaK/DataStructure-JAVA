class QueueLinkedList<T> {
    // Node class to represent each element in the queue
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;
    private int size;

    // Constructor
    public QueueLinkedList() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Enqueue method - adds an element to the end of the queue
    public void enqueue(T element) {
        Node newNode = new Node(element);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue method - removes the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return result;
    }

    // Peek method - returns the front element without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    // isEmpty method - checks if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Size method - returns the number of elements in the queue
    public int size() {
        return size;
    }
}
