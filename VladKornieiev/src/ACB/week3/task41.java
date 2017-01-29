package ACB.week3;


import static ACB.week2.ArrayUtils.printArr;

/*
Удалить из предложения слова которые повторяются.
 */
public class task41 {
    public static void main(String[] args) {
        String str = "Hello,dear dear friend.I am I very glad to see you:glad!";
        String[] array = str.split("\\W+");
        // check
        printArr(array);

        // removing
        for (int i = 0; i < array.length; i++) {
            // if indexes not the same - there are 2 or more words array[i];
            if (str.indexOf(array[i]) != str.lastIndexOf(array[i])){
                str = str.replaceAll(array[i], "");
            }
        }

        // to delete unnecessary whitespaces
        str = str.replaceAll("\\W+", " ");
        System.out.println(str);
    }
}
