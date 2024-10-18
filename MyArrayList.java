package datastructure;

public class MyArrayList<T> {

    private T[] arr;
    private int size;

    // Constructor: Initializes the array with a default size of 8
    public MyArrayList() {
        arr = (T[]) new Object[8];
        size = 0;
    }

    // Adds an element to the list
    public void add(T val) {
        if (size == arr.length) {
            resize(arr.length * 2); // Double the array size when full
        }
        arr[size++] = val;
    }

    // Adds an element at the specified index
    public void add(int index, T val) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        shiftRight(index);
        arr[index] = val;
    }

    // Resizes the array to a new size
    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    // Shifts elements to the right starting from the given index
    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        size++;
    }

    // Removes the element at the specified index and returns it
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T old = arr[index];
        shiftLeft(index);
        return old;
    }

    // Removes the first occurrence of the specified value and returns it
    public T remove(T val) {
        int index = indexOf(val);
        return (index != -1) ? remove(index) : null;
    }

    // Shifts elements to the left starting from the given index
    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        if (size > 0 && size < arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    // Returns the index of the first occurrence of the value, or -1 if not found
    public int indexOf(T val) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    // Returns the index of the last occurrence of the value, or -1 if not found
    public int lastIndexOf(T val) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] != null && arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    // Replaces the element at the specified index and returns the old value
    public T set(int index, T val) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T old = arr[index];
        arr[index] = val;
        return old;
    }

    // Returns the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return arr[index];
    }

    // Returns the size of the list
    public int size() {
        return size;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clears the list
    public void clear() {
        arr = (T[]) new Object[8];
        size = 0;
    }

    // Checks if the list contains the specified value
    public boolean contains(T val) {
        return indexOf(val) != -1;
    }

    // Removes all occurrences of the specified value from the list
    public void removeAll(T val) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(val)) {
                remove(i);
                i--; // Re-adjust the index after removal
            }
        }
    }

    // Adds all elements from another MyArrayList to this list
    public void addAll(MyArrayList<T> other) {
        while (other.size + this.size > arr.length) {
            resize(arr.length * 2);
        }
        for (int i = 0; i < other.size; i++) {
            this.add(other.get(i));
        }
    }

    // Checks if this list is equal to another MyArrayList
    public boolean equals(MyArrayList<T> other) {
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            T thisVal = this.get(i);
            T otherVal = other.get(i);
            if (thisVal == null ? otherVal != null : !thisVal.equals(otherVal)) {
                return false;
            }
        }
        return true;
    }

    // Returns the string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }}
