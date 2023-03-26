package week_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import week_2.card.Card;
import week_2.card.TestCard;

public class Exercise7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập N:");
        int n = sc.nextInt();
        System.out.println("Nhập M: ");
        int m = sc.nextInt();

        // Sinh day sô ngẫu nhiên
        Random generator = new Random();
        int[] intArray = new int[n];

        int count = 0;
        int temp;
        boolean check;
        
        while(count < n) {
            check = false;
            temp = generator.nextInt(m);

            for (int i = 0; i < count; i++) {
                if(temp == intArray[i]) {
                    check = true;
                    break;
                }
            }

            if(!check) {
                intArray[count] = temp;
                count++;
            }

        }
        
        System.out.println(Arrays.toString(intArray));


        // Tạo bộ bài
        TestCard test = new TestCard();
        Card[] deck1 = new Card[52];
        deck1 = test.create();

        // shuffle
        shuffle(deck1, 20);
        System.out.println(Arrays.toString(deck1));

    }

    // shuffle
    public static void shuffle(Card[] deck, int n) {// số lần tráo là n
        Random generator = new Random();
        int j;
        for (int i = 0; i < n; i++) {
            j = generator.nextInt(n);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }


    }

}
