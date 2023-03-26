package week_2;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        // int array
        int array[] = {1, 5, 2, 3, 4};

        // print after sort
        System.out.println(Arrays.toString(array));
        System.out.println();

        // print array before sort
        selectSort(array);
        System.out.println(Arrays.toString(array));

    }

    // bubble Sort
    public static void selectSort(int[] a) {
        int countCompare = 0;
        int countSwap = 0;
        int n = a.length;

        // find min element set up at first position
        for (int i = n - 1; i > 0; i--) {

            int idx_max = i;
            for (int j = 0; j < i; j++) {
                if(a[j] > a[idx_max])  {
                    idx_max = j;
                    countCompare++;
                }
                
            }

            // swap
            int temp = a[i];
            a[i] = a[idx_max];
            a[idx_max] = temp;
            countSwap++;
            
            // print trạng thái sau mỗi vòng lặp
            System.out.println("Lần thứ " + (n - i));
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();


        }


        System.out.println("Số lần so sánh: " + countCompare);
        System.out.println("Số lần hoán đổi: " + countSwap);

    
    }

}
