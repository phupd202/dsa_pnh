package week_2;

import java.util.Arrays;

public class SortGeneric {

    // bubbleSort
    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        int n = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    T temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
                
            }
        }
    }

    // selectionSort
    public static <T extends Comparable<T>> void selectSort(T[] a) {
        int n = a.length;

        for (int i = n - 1; i > 0; i--) {

            int idx_max = i;
            for (int j = 0; j < i; j++) {
                if(a[j].compareTo(a[idx_max]) > 0)  {
                    idx_max = j;
                }
            }

            T temp = a[idx_max];
            a[idx_max] = a[i];
            a[i] = temp;
        }
    }

    // insertionSort
    public static <T extends Comparable<T>> void insertSort(T[] a) {
        int n = a.length;

        for (int i = 0; i < a.length; i++) {
            T key = a[i];
            int j = i;
            while(j > 0 && a[j - 1].compareTo(key) > 0) {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = key;
        }
    }

    public static void main(String[] args) {
        Character[] data1 = {'e','d','g','a','c','f', 'b'}; // for test bubble sort
        Character[] data2 = {'e','d','g','a','c','f', 'b'};// for test selection sort
        Character[] data3 = {'e','d','g','a','c','f', 'b'};// for test insertion sort

        System.out.println("Test trên 3 mẫu giống hệt nhau: ");
        bubbleSort(data1);
        System.out.println("Test bubble sort: ");
        System.out.println(Arrays.toString(data1));

        selectSort(data2);
        System.out.println("Test selection sort: ");
        System.out.println(Arrays.toString(data2));

        insertSort(data3);
        System.out.println("Test insertion sort: ");
        System.out.println(Arrays.toString(data3));


    }

}
