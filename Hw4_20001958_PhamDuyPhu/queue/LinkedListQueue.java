package Hw4_20001958_PhamDuyPhu.queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> { 
    class Node {
        E  data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int count = 0;


    @Override
    public void enqueue(E element) {
        Node node = new Node();
        node.data = element;
        node.next = null;

        if(isEmpty()) {
            top = node;
            bot = node;
            count++;
        } else {
            bot.next = node;
            bot = node;
            count++;
        }
        
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new NullPointerException("Queue rỗng");
        }

        E data = top.data;
        if(count == 1) {
            top = null;
            bot = null;
            count--;
        } else {
            top = top.next;
            count--;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    class QueueIterator<T> implements Iterator<T> {
        Node currentNode = top;

        @Override
        public boolean hasNext() {
            return (currentNode != null);
        }

        @Override
        public T next() {
            T result = (T) currentNode.data;
            currentNode = currentNode.next;
            return result;

        }

    }

    public int size() {
        return count;
    }
    
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();

        // dequeue 5 elements
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(4);

        System.out.println("Size before dequeue: " + queue.size());
            
        // test iterator
        System.out.println("Test iterator(), next(), hasNext(): ");
        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        // test for each
        System.out.println("Test for each: ");
        for (Integer e : queue) {
            System.out.println(e);
        }
        
        //test size
        System.out.println("Test dequeue: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(queue.dequeue());
        }

        System.out.println("Size after dequeue: " + queue.size());
    }
}
//tested
