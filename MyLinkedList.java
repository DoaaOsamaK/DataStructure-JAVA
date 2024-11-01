package datastructure;

import java.util.NoSuchElementException;

public class MyLinkedList<D> {
    class Node<D> {
        D value;
        Node<D> next;

        Node(D value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<D> head;
    private Node<D> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(D value) {
        Node<D> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, D val) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            add(val);
        } else {
            Node<D> newNode = new Node<>(val);
            Node<D> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public D remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return removeFirst();
        } else {
            Node<D> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            D old = current.next.value;

            if (index == size - 1) {
                tail = current;
                current.next = null;
            } else {
                current.next = current.next.next;
            }

            size--;
            return old;
        }
    }

    public void addFirst(D val) {
        Node<D> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public D removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        D old = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        return old;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public D getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.value;
    }

    public D getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.value;
    }

    public String print() {
        StringBuilder s = new StringBuilder();
        Node<D> current = head;

        while (current != null) {
            s.append(current.value);
            if (current.next != null) {
                s.append(" , ");
            }
            current = current.next;
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return print();
    }

    public void removeDuplicates() {
        Node curr = head;

        while (curr != null && curr.next != null) {
            Node temp = curr;

            while (temp.next != null) {
                if (curr.value == temp.next.value) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
    }

    public void rotateRight() {
        if (head == null || head.next == null) {
            return;
        }
        Node cur = head;
        Node temp = head;

        while (cur.next.next != null) {
            cur = cur.next;
        }
        temp = cur.next;
        temp.next = head;
        head = temp;
        cur.next = null;
    }

    public boolean isPalendrom() {
        while (true) {
            Node cur = head;
            if (cur == null || cur.next == null) {
                return true;
            }
            rotateRight();
            if (head.value != head.next.value) {
                return false;
            }
            removeFirst();
            removeFirst();
        }
    }


}
