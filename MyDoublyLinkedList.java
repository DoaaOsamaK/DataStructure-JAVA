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
