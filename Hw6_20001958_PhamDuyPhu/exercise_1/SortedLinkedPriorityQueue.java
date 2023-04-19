package exercise_1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements
        PriorityQueueInterface<K,E>{

    // Inter class
    static class LinkedListEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        // constructor
        public LinkedListEntry(K key, E element) {
            this.key = key;
            this.element = element;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }

        public String toString() {
            return "Key = " + this.key + ", Value = " + this.element;
        }
    }

    private int n = 0;
    Node<K, E> priQueue = null;

    // Inter class
    class Node<K extends Comparable<K>, E> {
        K key;
        E element;
        Node<K, E> next;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        Node<K, E> newNode = new Node<K, E>();
        newNode.key = entry.getKey();
        newNode.element = entry.getValue();

        // Nếu rỗng
        if(this.size() == 0) {
            priQueue = newNode;
        } else 
            if(entry.getKey().compareTo(priQueue.key) < 0) {
                newNode.next = priQueue;
                priQueue = newNode;
            } else {
                Node<K, E> curr = priQueue;
                Node<K, E> nextCurr = priQueue.next;
                
                K keyElement = entry.getKey();
                while(keyElement.compareTo(nextCurr.key) > 0 && nextCurr != null) {
                    curr = curr.next;
                    nextCurr = nextCurr.next;
                }
                curr.next = newNode;
                newNode.next = nextCurr;
            }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        Node<K, E> newNode = new Node<K, E>();
        newNode.key = k;
        newNode.element = e;

        if(this.size() == 0) {
            priQueue  = newNode;
        } else 
            // Duy trì 2 con trỏ liền nhau
            if(k.compareTo(priQueue.key) < 0) {
                newNode.next = priQueue;
                priQueue = newNode;
            } else {
                Node<K, E> curr = priQueue;
                Node<K, E> nextCurr = priQueue.next;
                
                while(k.compareTo(nextCurr.key) > 0 && nextCurr != null) {
                    curr = curr.next;
                    nextCurr = nextCurr.next;
                }
                curr.next = newNode;
                newNode.next = nextCurr;
            }
        n++;

    }

    @Override
    public Entry<K, E> removeMin() {
        LinkedListEntry<K, E> result = new LinkedListEntry<K, E>(null, null);

        if(isEmpty()) {
            throw new NullPointerException("Queue đang rỗng");
        } else {
            result.key = priQueue.key;
            result.element = priQueue.element;

            priQueue = priQueue.next;
            
        }
        n--;
        return result;

    }

    @Override
    public Entry<K, E> min() {
        LinkedListEntry<K, E> result = new LinkedListEntry<K, E>(null, null);
        result.key = priQueue.key;
        result.element = priQueue.element;
        return result;
    }

    public static void main(String[] args) {
        SortedLinkedPriorityQueue<Integer, String> priQueue = new SortedLinkedPriorityQueue<Integer, String>();
        
        LinkedListEntry<Integer, String> entry1 = new LinkedListEntry<Integer, String>(3, "Phu");
        LinkedListEntry<Integer, String> entry2 = new LinkedListEntry<Integer, String>(1, "Pham");
        LinkedListEntry<Integer, String> entry3 = new LinkedListEntry<Integer, String>(3, "Duy");

        priQueue.insert(entry1);
        priQueue.insert(entry2);
        priQueue.insert(entry3);

        // size of queue
        System.out.println("Size = " + priQueue.size());

        // Min of queue
        System.out.println("Min: " + priQueue.min());

        //before remove min
        System.out.println("Before remove, size = " + priQueue.size());

        // remove Min
        System.out.println("Remove min: " + priQueue.removeMin());

        //after remove min
        System.out.println("After remove, size = " + priQueue.size());

    }

}