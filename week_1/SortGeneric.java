package week_1;

import java.util.Scanner;

public class SortGeneric{
    public static  void main(String[] args) { 
        Scanner sc = new Scanner(System.in);

        // Input size
        // System.out.println("Enter size of the array: ");
        // int n = sc.nextInt();

        Integer a[] = {2, 4, 1, 5, 3, 6};
        sort(a);
        printArray(a);

        Double b[] = {2.5, 4.1, 2.0, 2.7, 9.1};
        sort(b);
        printArray(b);

        Character c[] = {'r', 'b', 'a', 'f', 'j', 'h'};
        sort(c);
        printArray(c);
        
    }

    //sort
    public static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    T temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                
            }
        }
    }

    // printArray
    public static <T> void printArray(T[] a) {
        int n = a.length;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //search
    public static <T> boolean search(T[] a, T e) {

        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(e)); return true;
        }
        return false;
    }

}
