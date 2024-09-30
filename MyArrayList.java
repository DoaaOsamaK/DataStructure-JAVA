package datastructure;

public class MyArrayList<Integer> {
    
    private Integer[] arr;
    private int size;

    public MyArrayList() {
        arr = (Integer[]) new Object[8]; // Initialized array with size 8
        size = 0;
    }
    
    // ADD
    public void add(Integer val) {
        // If the array is full
        if (size == arr.length) {
            resize(arr.length * 2); // Double the size
        }
        // Add the new element
        arr[size++] = val;
    }
    
    private void resize(int newSize) {
        // Create new array with larger size
        Integer[] newArray = (Integer[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        // Update the reference to point to the new array
        arr = newArray;
    }
    
    public void add(int index, Integer val){
        if(index>=0&&index<arr.length){
           if(size==arr.length){
            resize(arr.length*2);
        }
           shiftRight(index);
           
           arr[index]=val;
        }
           else{
                    throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size); 
                         }}
    
    private void shiftRight(int index){
        for (int i = size; i < index; i--) {
            arr[i]=arr[i-1];
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            s.append(arr[i]);
            if (i != size - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void clear(){
        arr=(Integer[]) new Object[5];
        size=0;
    }
     public Integer remove(int index) {
        if (index >= 0 && index < size) {
            Integer old = arr[index];
            shiftLeft(index);
            return old;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        if (size > 0 && size < arr.length / 4) {
            resize(arr.length / 2);
        }
    }

     public Integer remove(Integer val) {
        int index = indexOf(val);
        if (index != -1) {
            return remove(index);
        } else {
            return null;
        }
    }

     public int indexOf(Integer val) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public Integer set(int index, Integer val) {
        Integer old;
        if (index >= 0 && index < size) {
            old = arr[index];
            arr[index] = val;
            return old;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public Integer get(int index) {
        if (index >= 0 && index < size) {
            return arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        }
    }

    public boolean equals(MyArrayList<Integer> arr) {
        if (this.size != arr.size) {
            return false;
        }
        for (int i = 0; i < arr.size; i++) {
            Integer x = arr.get(i);
            Integer y = this.get(i);
            if (x == null ? y != null : !x.equals(y)) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Integer val){
        return indexOf(val)!=-1;
    }

    public void removeAll(Integer val){
        for (int i = 0; i < size; i++) {
            if(arr[i]!=null&&arr[i].equals(val)){
                remove(i);
                i--;
            }
        }
    }

     public void addAll(MyArrayList<Integer> array2){
        
        while(array2.size+this.size>arr.length){
            resize(arr.length*2);
        }
        
        for (int i = 0; i < array2.size; i++) {
            this.add(array2.get(i));
        }
        
    }
}
    
    
    

