package week_2.card;


import java.util.Comparator;

public class Card implements Comparator<Card>,Comparable<Card> {
    
    // enum Rank
    enum Rank {
        ÁT(1), HAI(2), BA(3), BỐN(4), NĂM(5), SÁU(6), BẢY(7), TÁM(8), CHÍN(9), MƯỜI(10), J(11), Q(12), K(13);
        int valueRank;
        private Rank(int valueRank) {
            this.valueRank = valueRank;
        }

        private int getValueRank() {
            return this.valueRank;
        }
    }

    // enum Suite
    enum Suit{
        BÍCH(1), TÉP(2), RÔ(3), CƠ(4);

        int valueSuit;
        private Suit(int valueSuit) {
            this.valueSuit = valueSuit;
        }

        private int getValueSuit() {
            return valueSuit;
        }
    }


    // Card class
    private Rank rankValue;
    private Suit suitValue;

    // constructor
    public Card(Rank rankValue, Suit suiteValue) {
        this.rankValue = rankValue;
        this.suitValue = suiteValue;
    }
    
    public Card( ) {
        
    }

    // getRank
    public int getRank() {
        return this.rankValue.getValueRank();
    }

    //getSuit
    public int getSuit() {
        return this.suitValue.getValueSuit();
    }

    // toString
    public String toString() {
        return this.rankValue + " " + this.suitValue;
    }

    // nếu rank bằng nhau, so sanh đến chất, nếu chất bằng nhau thì so sanh đến rank
    // Implement Comparator
    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getRank() != o2.getRank()) {
            return o1.getRank() - o2.getRank();
        } else{
            return o1.getSuit() - o2.getSuit();
       }
    }

    // Implement Comparable
    @Override
    public int compareTo(Card o) {
        if(this.getRank() != o.getRank()) {
            return (this.getRank() - o.getRank()) % 2;
        } else {
            return (this.getSuit() - o.getSuit()) % 2;
        }
    }

}
