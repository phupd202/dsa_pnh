package exercise_1;

// 1 5 6 7 2
public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    public static class ArrEntry<K, E> implements Entry<K, E> {
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

        @Override
        public String toString() {
            return "Key: " + this.key + ", Value: " + this.element;
        }
    }

    ArrEntry<K, E>[] array;
    public int n = 0;
    protected int defaultsize = 1000;
    int front = 0;
    int tail = 0;

    public SortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultsize];

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
        if (n >= array.length) {
            throw new IndexOutOfBoundsException("Priority Queue đã đầy");
        }

        K newKey = entry.getKey();
        int idxCur = n - 1;
        while (idxCur >= 0 && array[idxCur].getKey().compareTo(newKey) > 0) {
            array[idxCur + 1] = array[idxCur];
            idxCur--;
        }

        array[idxCur + 1] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        if (n >= array.length) {
            throw new IndexOutOfBoundsException("Priority Queue đã đầy");
        }

        ArrEntry<K, E> element = new ArrEntry<K, E>(k, e);

        int idxCur = n - 1;
        while (idxCur >= 0 && array[idxCur].getKey().compareTo(k) > 0) {
            array[idxCur + 1] = array[idxCur];
            idxCur--;
        }

        array[idxCur + 1] = element;
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new NullPointerException("Priority Queue rỗng");
        }
        Entry<K, E> result = array[front];
        array[front] = null;
        front++;
        n--;
        return result;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new NullPointerException("Priority Queue rỗng");
        }
        Entry<K, E> result = array[front];
        return result;
    }

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

// Key word Array.newInstance