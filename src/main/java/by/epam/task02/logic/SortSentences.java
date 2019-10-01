package by.epam.task02.logic;

import java.util.Arrays;
import java.util.Comparator;

public class SortSentences {


    public String sortSentence(String sentence) {
        String ss[] = sentence.split(" ");

        Arrays.sort(ss, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        return sentence;
   }

}

