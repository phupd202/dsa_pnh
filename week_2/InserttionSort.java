package week_2;

import java.util.Arrays;
import java.util.Scanner;

public class InserttionSort {
    public static void main(String[] args) {
        
        // int array
        int array[] = {1, 5, 2, 3, 4};

        // print after sort
        System.out.println(Arrays.toString(array));
        System.out.println();

        // print array before sort
        insertSort(array);
        System.out.println(Arrays.toString(array));
    
        
    }

    // insertionSort
    public static void insertSort(int array[]) {
        int countCompare = 0;
        int countSwap = 0;

        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while(j > 0 && array[j] > key) {
                countCompare++;
                array[j + 1] = array[j]; // mỗi lần dịch chuyển coi như là 1 lần hoán vị
                j--;

            }
            array[j + 1] = key;
            countSwap++;
            
            //print trạng thái sau mỗi vòng lặp
            System.out.println("Lần thứ " + i);
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
            
        }

        System.out.println("Số lần so sánh: " + countCompare);
        System.out.println("Số lần hoán đổi: " + countSwap);
        
        

    }
}
