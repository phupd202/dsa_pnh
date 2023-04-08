package Hw4_20001958.queue;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue; 
    private int n = 0; 
    private int top = 0;
    private int count = 0; // só phân tử hienj có
    private int default_size = 100; // size mặc định

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) {
        if(count >= queue.length) {
            throw new IllegalStateException("Queue đã đầy!!");
        }
        int avail = (top + count) % queue.length;
        queue[avail] = element;
        count++;
        
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new NullPointerException("Không thực hiện được, queue rỗng");
        }
        
        E topQueue = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length; // phòng trương hợp khi hết mảng
        return topQueue;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }



    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0; // con trỏ duyệt 

        @Override
        public boolean hasNext() {
            return num < count;
        }

        // mỗi lần lấy ra một phần tử, num++
        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
    
        Iterator<Integer> q = queue.iterator();

        for (Integer e : queue) {
            System.out.println(e);
        }
    
        // queue.dequeue();
        // while(q.hasNext()) {
        //     System.out.println(q.next());
        // }

        
    }

}