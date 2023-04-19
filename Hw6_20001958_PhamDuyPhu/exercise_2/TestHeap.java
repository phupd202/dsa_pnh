package exercise_2;

import exercise_1.SortedArrayPriorityQueue.ArrEntry;

public class TestHeap {

    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> priHeap = new MinHeapPriorityQueue<Integer, String>();
        ArrEntry<Integer, String> entry1 = new ArrEntry<Integer,String>(3, "Phú");
        ArrEntry<Integer, String> entry2 = new ArrEntry<Integer,String>(1, "Pham");
        ArrEntry<Integer, String> entry3 = new ArrEntry<Integer,String>(3, "Duy");

        priHeap.insert(entry1);
        priHeap.insert(entry2);
        priHeap.insert(entry3);

        System.out.println(priHeap.min());


    }
}
