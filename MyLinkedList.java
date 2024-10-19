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
      

}
