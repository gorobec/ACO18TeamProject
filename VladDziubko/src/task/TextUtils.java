package task;

import java.util.Arrays;

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
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        String[] arr = text.split("; ");
        return arr;
    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {
//        TODO write your code here
        String[] resArray = new String[]{};

        return null;
    }

    public static boolean findDublicates(String[] words) {
        boolean bool = true;
        for (int i = 0; i < words.length; i++) {
            if (!(words[i].equals(words[i + 1]))) {
                return bool;
            } else {
                bool = false;
            }
        }
        return bool;
    }

    public static String[] addWord(String[] words) {
        String[] resArray = new String[]{};
        for (int i = 0; i < words.length; i++) {
            resArray[i] += findDublicates(words) == true ? words[i] : null;
        }
        return resArray;
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {
//      TODO write your code here
        Arrays.sort(uniqueWords);
        return uniqueWords;
    }
}
