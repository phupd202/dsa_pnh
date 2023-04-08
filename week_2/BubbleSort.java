package week_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter size of the array: ");
        // int n = sc.nextInt();

        // int array
        // int[] array = new int[n];

        // // random generator
        // Random generator = new Random();
        
        // for (int i = 0; i < array.length; i++) {
        //     array[i] = generator.nextInt(100);
        // }

        int array[] = {1, 5, 3, 2, 4};
        
        // print after sort
        System.out.println(Arrays.toString(array));
        System.out.println();

        // print array before sort
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    // bubble Sort
    public static void bubbleSort(int[] a) {
        int temp;
        int countCompare = 0;
        int countSwap = 0;

        for (int i = 0; i < a.length; i++) {
            for(int j = 1; j < a.length - i; j++) {
                countCompare++;
                if(a[j - 1] > a[j]) {
                    // swap
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                    countSwap++;
                }

            }

            // // In day sau moi buoc sort
            System.out.println("Lần " + i);
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }

        System.out.println("Số lần so sánh: " + countCompare);
        System.out.println("Số lần hoán đổi: " + countSwap);

    }
    // tested
}
