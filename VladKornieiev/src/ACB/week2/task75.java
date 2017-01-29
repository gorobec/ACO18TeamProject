package ACB.week2;

/*
Заменить в строке все символы 'a' на '@' и
вывести новую строку
// "array is a data type" -> "@rr@y is @ d@t@ type"
 */
public class task75 {
    public static void main(String[] args) {
        String str = "array is a data type";
        String result = "";

        for (int i = 0; i < str.length() ; i++) {
            result += (str.substring(i,i+1).equals("a")) ?
                    "@" : str.substring(i,i+1);
        }

        System.out.println(result);
    }
}
