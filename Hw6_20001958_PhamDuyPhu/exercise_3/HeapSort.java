package exercise_3;

import exercise_2.MinHeapPriorityQueue;

public class HeapSort<K extends Comparable<K>, E> extends MinHeapPriorityQueue<K, E> {
    private int n = super.size();

    public HeapSort() {
        // tạo ra 1 mảng ArrEntry kế thừa từ SortedArray
        super();
    }

    // heapsort
    public void heapSort() {

        // Sắp xếp tăng dần
        int lastNode = size() - 1;
        while (lastNode > 0) {
            // Đưa phần tử cuối lên đầu heap
            swap(heapPQ, 0, lastNode);
            // Thực hiện downHeap từ đỉnh heap để đưa phần tử mới về vị trí phù hợp
            downHeap(lastNode);
            lastNode--;
        }
    }

    // down heap
    public void downHeap(int lastNode) {
        int idxParent = 0;
        int j = 2 * idxParent + 1; // Khởi tạo giá trị cho biến j

        while (j < lastNode) {
            if (j + 1 < lastNode && heapPQ[j + 1].getKey().compareTo(heapPQ[j].getKey()) < 0)
                j++;

            if (heapPQ[j].getKey().compareTo(heapPQ[idxParent].getKey()) < 0) {
                swap(heapPQ, j, idxParent);
            } else {
                break;
            }

            idxParent = j;
            j = 2 * idxParent + 1; // Cập nhật giá trị cho biến j
        }

    }

    public void swap(ArrEntry<K, E> heapPQ[], int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

}
