package week_2.card;

import java.util.Arrays;
import week_2.card.Card.Rank;
import week_2.card.Card.Suit;

public class TestCard {
    private Card[] deck = new Card[52];

    public Card[] create() {
        int count = 0;
        for (int i = 0; i < 13; i++) {
            Rank rank = Rank.values()[i];
            for (int j = 0; j < 4; j++) {
                Suit suit = Suit.values()[j];

                Card card = new Card(rank, suit);
                this.deck[count] = card;
                count++;

            }
        }
        return deck;
    }

    // Sử dụng phương thức sort ở bài 5, để sắp xếp bộ bài
    public <T extends Comparable<T>> void bubbleSort(T[] a) {
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

    public static void main(String[] args) {
       TestCard test = new TestCard();
       Card[] deck1 = new Card[52];
       deck1 = test.create();

       // Sử dụng thư viện Arrays, phương thức sort(T[] a,Comparator<? super T> c) để sắp xếp bộ bài.
       Card comparecard = new Card();
       Arrays.sort(deck1, comparecard);
       for (int i = 0; i < deck1.length; i++) {
            System.out.println(deck1[i]);
       }

       // Cài đặt giao diện Comparable cho đối tượng Card, sử dụng các phương thức sắp xếp đã làm ở bài 5 để sắp xếp bộ bài.
       test.bubbleSort(test.create());   
    }
}