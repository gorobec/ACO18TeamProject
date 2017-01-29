package oop.weak1.test_task.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param text
     * @return sorted by natural order array of unique words
     */
    public static String[] getUniqueSortedWords(String text) {
//        TODO find mistake and correct it, so the method works correctly
        String[] words = getWords(text);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }

    /**
     * @param text
     * @return array with words, get from receive text
     * if received argument is null
     * or text length is zero
     * return array with zero length
     */
    public static String[] getWords(String text) {

//        TODO write your code here
        if (text != null && !text.isEmpty()) {
            String[] words = text.split("; ");
            return words;
        } else {
            String[] words = new String[0];
            return words;
        }

    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {

//        TODO write your code here

        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (!list.contains(words[i])) {
                list.add(words[i]);
            }
        }

       /* String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
*/
        return list.toArray(new String[list.size()]);
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here
//        Arrays.sort(uniqueWords);

        String buffer;
        for (int i = 0; i < uniqueWords.length - 1; i++) {
            for (int j = i + 1; j < uniqueWords.length; j++) {
                if (uniqueWords[i].compareTo(uniqueWords[j]) > 0) {

                    buffer = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = buffer;

                }
            }
        }

        return uniqueWords;
    }
}
