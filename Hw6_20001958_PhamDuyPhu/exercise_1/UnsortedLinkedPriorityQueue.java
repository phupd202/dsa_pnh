package exercise_1;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements
        PriorityQueueInterface<K, E> {

    // Inter class
    class Node<K extends Comparable<K>, E> {
        K key;
        E element;
        Node<K, E> next;
    }

    Node<K, E> priQueue = null;
    private int n = 0;

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

        if(isEmpty()) {
            priQueue = newNode;
        } else {
            // chèn vào đầu
            newNode.next = priQueue;
            priQueue = newNode;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        Node<K, E> newNode = new Node<K, E>();
        newNode.key = k;
        newNode.element = e;

        if(isEmpty()) {
            priQueue = newNode;
        } else {
            // chèn vào đầu
            newNode.next = priQueue;
            priQueue = newNode;
        }
    n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if(isEmpty()) {
            return null;
        }
        
        LinkedListEntry<K, E> result = new LinkedListEntry<K, E>(null, null);
        K minKey = priQueue.key;

        // tìm minKey
        Node<K, E> tmp = priQueue;
        while(tmp != null) {
            if(tmp.key.compareTo(minKey) < 0) {
                minKey = tmp.key;
            }
            tmp = tmp.next;
        }

        // remove minKey
        if(priQueue.key.equals(minKey) || size() == 1) {
            result.key = priQueue.key;
            result.element = priQueue.element;
            priQueue = priQueue.next;
        } else {
            // 1 con trỏ trỏ tới minKey, 1 con trỏ trỏ tới node trước của minKey
            Node<K, E> preMinKey = priQueue;
            Node<K, E> pointMinKey = priQueue.next;

            while(pointMinKey.key != minKey) {
                preMinKey = preMinKey.next;
                pointMinKey = pointMinKey.next;
            }
            
            // get result
            result.key = pointMinKey.key;
            result.element = pointMinKey.element;

            preMinKey.next = pointMinKey.next;

        }
        n--;
        return result;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) {
            return null;
        }
        
        LinkedListEntry<K, E> result = new LinkedListEntry<K, E>(null, null);
        K minKey = priQueue.key;

        // tìm minKey
        Node<K, E> tmp = priQueue;
        while(tmp != null) {
            if(tmp.key.compareTo(minKey) < 0) {
                minKey = tmp.key;
            }
            tmp = tmp.next;
        }

        // remove minKey
        if(priQueue.key.equals(minKey) || size() == 1) {
            result.key = priQueue.key;
            result.element = priQueue.element;
            priQueue = priQueue.next;
        } else {
            // 1 con trỏ trỏ tới minKey, 1 con trỏ trỏ tới node trước của minKey
            Node<K, E> preMinKey = priQueue;
            Node<K, E> pointMinKey = priQueue.next;

            while(pointMinKey.key != minKey) {
                preMinKey = preMinKey.next;
                pointMinKey = pointMinKey.next;
            }
            
            // get result
            result.key = pointMinKey.key;
            result.element = pointMinKey.element;
        }
        n--;
        return result;
        
    }

    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> priQueue = new UnsortedLinkedPriorityQueue<Integer, String>();
        
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