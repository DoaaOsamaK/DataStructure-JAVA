public class MyDoublyLinkedList {
    private class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void addEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position == 1) {
            addFront(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            addEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        }
    }

    public void deleteAtSpecificPosition(int position) {
        if (position == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    public void deleteNode(Node del) {
        if (head == null || del == null) {
            return;
        }

        if (head == del) {
            head = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        } else {
            tail = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }
    }

    public void deleteAtBeginning() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (tail == null) return;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void displayForward() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node node = tail;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyDoublyLinkedList dll = new MyDoublyLinkedList();

        dll.addEnd(1);
        dll.addEnd(2);
        dll.addEnd(3);
        dll.addEnd(4);
        dll.addEnd(5);

        System.out.print("After insertion at tail: ");
        dll.displayForward();

        dll.addFront(0);
        System.out.print("After insertion at head: ");
        dll.displayForward();

        dll.insertAtPosition(6, 3);
        System.out.print("After insertion at position 3: ");
        dll.displayForward();

        dll.deleteAtBeginning();
        System.out.print("After deletion at the beginning: ");
        dll.displayForward();

        dll.deleteAtEnd();
        System.out.print("After deletion at the end: ");
        dll.displayForward();

        dll.deleteAtSpecificPosition(2);
        System.out.print("After deletion at position 2: ");
        dll.displayForward();

        System.out.print("Display in reverse order: ");
        dll.displayBackward();
    }
}
