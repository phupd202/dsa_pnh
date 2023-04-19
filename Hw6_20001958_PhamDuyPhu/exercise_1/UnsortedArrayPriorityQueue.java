package exercise_1;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;

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

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }  

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;
    
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
        if(n >= defaultsize) {
            throw new IndexOutOfBoundsException("Queue đã đầy");
        } 
        array[n++] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        if(n >= defaultsize) {
            throw new IndexOutOfBoundsException("Priority queue đã đầy");
        }
        ArrEntry<K, E> entry = new ArrEntry<K, E>(k, e);
        array[n++] = entry;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        // tìm min index key
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if(array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }

        Entry<K, E> min = array[minIndex];
        array[minIndex] = array[n];
        array[n] = null;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        Entry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            if(array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    // chưa viết toString
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, Character> queue = new SortedArrayPriorityQueue<>();
        queue.insert(1, 'D');
        queue.insert(7, 'G');
        queue.insert(5, 'H');
        
        System.out.println("Min: ");
        System.out.print(queue.min() + "\n");

        System.out.println("Size trước khi xoá: ");
        System.out.print(queue.size() + "\n");

        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Size sau khi xoá: ");
        System.out.print(queue.size());
    }
    
    
}
