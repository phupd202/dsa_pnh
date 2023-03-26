package week_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordCount {
    private String word;
    private int count = 0;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public WordCount getCount(String text, String word) {
        int count = 0;
        String[] words = text.trim().split(" ");
        List<String> listWords = new ArrayList<String>();
        
        Collections.addAll(listWords, words);

        if(listWords.contains(word)) {
            for (int i = 0; i < listWords.size(); i++) {
                if(listWords.get(i).equals(word)) {
                    this.count++;
                }
                
            }
            return new WordCount(word, count);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "[word: " + word + ", count: " + count + "]";
    }


}
