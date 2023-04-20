package exercise_3;

import java.util.Arrays;

import exercise_1.SortedArrayPriorityQueue.ArrEntry;

public class TestHeapSort {
    public static void main(String[] args) {
        HeapSort<Integer, Character> heap = new HeapSort<Integer, Character>();

        ArrEntry<Integer, Character> entry1 = new ArrEntry<Integer, Character>(6, 'F');
        ArrEntry<Integer, Character> entry2 = new ArrEntry<Integer, Character>(5, 'E');
        ArrEntry<Integer, Character> entry3 = new ArrEntry<Integer, Character>(3, 'C');
        ArrEntry<Integer, Character> entry4 = new ArrEntry<Integer, Character>(4, 'D');
        ArrEntry<Integer, Character> entry5 = new ArrEntry<Integer, Character>(1, 'A');
        ArrEntry<Integer, Character> entry6 = new ArrEntry<Integer, Character>(2, 'B');

        heap.insert(entry1);
        heap.insert(entry2);
        heap.insert(entry3);
        heap.insert(entry4);
        heap.insert(entry5);
        heap.insert(entry6);

        System.out.println("Heap trước khi heap sort: ");
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.heapPQ[i]);
        }

        heap.heapSort();

        System.out.println("Sau khi heap sort: ");
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.heapPQ[i]);
        }

        // Kiểm tra kết quả với một mảng đã sắp xếp đúng bằng heapsort
        Integer[] expected = new Integer[] {6, 5, 4, 3, 2, 1};
        Integer[] actual = new Integer[heap.size()];

        for (int i = 0; i < heap.size(); i++) {
            actual[i] = heap.heapPQ[i].getKey();
        }

        if (Arrays.equals(expected, actual)) {
            System.out.println("Hàm heapSort() hoạt động đúng.");
        } else {
            System.out.println("Hàm heapSort() hoạt động sai.");
        }
    }
}
