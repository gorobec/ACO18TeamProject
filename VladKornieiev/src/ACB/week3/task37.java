package ACB.week3;

/*
Найти самое длинное слово в строке(разделенное одним пробелом)
 */
public class task37 {
    public static void main(String[] args) {
        String input = "hello my dear friend how are you what a beautiful day";
        String[] arr = input.split(" ");

        int max = 0;
        String maxLenWord = "";

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() > max){
                max = arr[i].length();
                maxLenWord = arr[i];
            }
        }
        System.out.println(maxLenWord);
    }
}
