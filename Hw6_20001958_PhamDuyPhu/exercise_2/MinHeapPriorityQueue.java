package exercise_2;

import exercise_1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    private static final int default_size = 100;
    public ArrEntry<K, E>[] heapPQ;
    private int n; // Thêm biến n

    public MinHeapPriorityQueue() {
        super();
        heapPQ = new ArrEntry[default_size];
        n = 0;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void upHeap() {
        n = size(); // Khởi tạo giá trị cho biến n
        int index = n - 1;

        while (index > 0) {
            if(heapPQ[index].getKey().compareTo(heapPQ[index/2].getKey()) < 0) {
                // swap với nút cha
                swap(heapPQ, index, (int) index / 2);
            } else {
                break;
            }
            index = (int) index / 2;
        }

    }

    // down heap
    public void downHeap() {
        int idxParent = 0;
        int j = 2 * idxParent + 1; // Khởi tạo giá trị cho biến j

        while (j < n) {
            if (j + 1 < n && heapPQ[j + 1].getKey().compareTo(heapPQ[j].getKey()) < 0)
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

    public void insert(ArrEntry<K, E> entry) {
        super.insert(entry);
        heapPQ[n++] = entry; // Thêm phần tử mới vào cuối heap
        upHeap();
    }

    public void swap(ArrEntry<K, E> heapPQ[], int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }
}
