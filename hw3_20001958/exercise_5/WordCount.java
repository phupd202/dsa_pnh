package hw3_20001958.exercise_5;
import hw3_20001958.exercise_4.SimpleLinkedList;

public class WordCount {
    private String word;
    private int count = 0;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }


    @Override
    public boolean equals(Object wc) {
        if(wc instanceof WordCount) {
            return this.word.equals(((WordCount) wc).getWord());
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "Phạm Duy Phú Phạm Duy Phú Phú";
        SimpleLinkedList<WordCount> result = new SimpleLinkedList<WordCount>();

        String[] words = s.toLowerCase().trim().split(" ");
        
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if(words[i].equals(words[j])) count++;
            }

            WordCount wc = new WordCount(words[i], count);
            if(!result.isContain(wc)) {
                result.add(wc);
            }
        }

        result.printLinkedList();

    }
}

