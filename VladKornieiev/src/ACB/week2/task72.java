package ACB.week2;

/*
Проверить или является число простым.
*/

public class task72 {
    public static void main(String[] args) {
        int number = 37;
        boolean simple = true;
        int i = 2;

        while(i < number && simple) {
            simple = (number % i == 0) ? false : true;
            i++;
        }
        System.out.println(simple);
    }
}
