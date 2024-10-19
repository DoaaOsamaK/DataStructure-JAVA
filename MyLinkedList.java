package datastructure;


public class MyLinkedList {
      class Node<D>{
        
        D value;
        Node<D> next;
        
        
        Node(D value){
            this.value=value;
            this.next=null;
        }
        
    }
    
    private Node<D> head;
    private Node<D> tail;
    private int size;
    
    MyLinkedList(){
        head=null;
        tail=null;
        size=0;
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


}
