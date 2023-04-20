package Hw4_20001958_PhamDuyPhu.stack;

import java.util.Arrays;
import java.util.Iterator;

public class StackArray<T> implements StackInterface<T>{
    private int defautlSize = 100;
    private T[] array;
    private int n = 0;

    //constructor 1
    public StackArray() {
        array = (T[]) new Object[defautlSize];
    }

    // constructor 2
    public StackArray(int capacity) {
        array = (T[]) new Object[capacity];
    }


    @Override
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

    @Override
    public void push(T element) {
        if(n >= array.length) {
            array = Arrays.copyOf(array, array.length + 10);
        }
        array[n++] = element;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new NullPointerException("Lỗi! Do xoá stack rỗng");
        }

        T data = array[n - 1];
        array[n - 1] = null;
        n--;
        return data;
    }

    @Override
    public boolean isEmpty() {
       return (n == 0);
    }

    @Override
    public T top() {
        if(isEmpty()) return null;
        return array[n - 1];
    }

    public int size() {
        return n;
    }
    
   public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<Integer>();
        // push
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        // test size()
        System.out.println("Size after push to stack: " + stack.size());

        // test iterator
        System.out.println("\nTest iterator(), next(), hasNext(): ");
        Iterator<Integer> iter = stack.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        //test for each
        System.out.println("\nTest for each: ");
        for (Integer e : stack) {
            System.out.print(e + " ");
            
        }

        // test pop
        System.out.println("\nTest pop: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }

        // test size after pop()
        System.out.println("\nSize after pop: " + stack.size());
   }
   // tested
}
