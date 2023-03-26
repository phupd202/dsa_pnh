package hw3_20001958.exercise_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Tạo lớp SimpleArrayList cài đặt giao diện ListInterface
public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    // constructor
    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    // add
    public void add(T data) {
        if(n < array.length) {
            array[n++] = data;
        } else {
            // copy from array to newArray
            array = Arrays.copyOf(array, array.length + 10);
            array[n++] = data;
        }
    }

    //get
    public T get(int i) {
        if(i < n) {
            return array[i];
        }
        return null;
    }

    // set
    public void set(int i, T data) {
        if(i < array.length) {
            array[i] = data;
        } else {
            array = Arrays.copyOf(array, array.length * 2);
            array[i] = data;
            n++;
        }

    }

    // remove
    public void remove(T data) {
        
        for (int i = 0; i < n; i++) {
            if(array[i] == data) {
                array[i] = null;
                n--;
                return;
            }
        }
    }

    // isContain
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if(array[i] == data) return true;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return (n == 0);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIdx = 0;
    
            @Override
            public boolean hasNext() {
                return  currentIdx < n && array[currentIdx] != null;
            }
    
            @Override
            public T next() {
                return array[currentIdx++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArrayList<Integer> a = new SimpleArrayList<Integer>(3);
        a.add(12);
        System.out.println(a.get(0));
    }
}
