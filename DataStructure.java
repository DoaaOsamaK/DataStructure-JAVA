
package datastructure;


public class DataStructure {

    
    public static void main(String[] args) {
        
        MyArrayList arr = new MyArrayList();
        arr.add(8);
        arr.add(0);
        arr.add(5);
        arr.add(85);
        arr.add(7);
        arr.add(3);
        arr.add(11);
        
        System.out.println(arr.toString());
        
        arr.clear();
        
        System.out.println(arr.toString());
        
    }
    
}
