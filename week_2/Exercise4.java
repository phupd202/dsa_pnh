package week_2;

import java.util.Random;

public class Exercise4 {

    
    public static int[] generator(int[] array) {
        Random rand = new Random();
        int n = array.length;

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(n);
        }
        return array;
    }

    public static void main(String[] args) {

        int[] data1 = new int[10];
        data1 = generator(data1);

        int[] data2 = new int[50];
        data1 = generator(data2);

        int[] data3 = new int[100];
        data1 = generator(data3);

        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(data1);
        long endTime = System.nanoTime();

        long totalTime = (endTime - startTime) / 1000;
        System.out.println(totalTime);
        
    }
}
