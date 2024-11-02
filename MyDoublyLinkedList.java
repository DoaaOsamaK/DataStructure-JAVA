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

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addEnd(int data) {
        Node newNode = new Node(data);
        Node last = head;

        if (head == null) {
            head = newNode;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
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

        if (current == null) { // Insert at the end if position is greater than list size
            addEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode; // Update tail if new node is the last node
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
            tail = current.prev; // Update tail if deleting the last node
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
        Node last = head;
        if (last == null) return;

        while (last.next != null) {
            last = last.next;
        }

        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }

}
