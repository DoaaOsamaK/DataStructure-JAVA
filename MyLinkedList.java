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
}
