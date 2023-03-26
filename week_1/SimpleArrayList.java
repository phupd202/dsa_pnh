package week_1;

import java.util.Iterator;

interface ListInterface<T> extends Iterable<T>{
    void add(T data);
    T get(int i);
    void set(int i, T data);
    void remove(T data);
    boolean isContain(T data);
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
}


public class SimpleArrayList<T> implements ListInterface<T>{
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    // constructor 1
    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    // Constructor 2
    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (n < this.defaultSize) {
            array[n] = data;
        } else {
           T[] newArray = (T[]) new Object[defaultSize + 10];

           // copy element from array to new Array
           System.arraycopy(array, 0, newArray, 0, n);
           newArray[n] = data;
           array = newArray;
        }
        n++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i > n) return null;
        else return array[i];
    }

    @Override
    public void set(int i, T data) {
        if(i < array.length) {
            array[i] = data;
        } else {
            T[] newArray = (T[]) new Object[defaultSize + 10];

           // copy element from array to new Array
           System.arraycopy(array, 0, newArray, 0, n);
           newArray[i] = data;
           array = newArray;
        }
        
    }

    @Override
    public void remove(T data) {
        if(array == null) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if(array[i] == data) {
                array[i] = array[i + 1];
            }
        }
       
    }

    @Override
    public boolean isContain(T data) {
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (array == null);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    
}
