package ACB.week1;

import java.util.Scanner;

/*
Посчитать сколько раз встречается символ 8 в заданном числе,
которое вводит юзер
			5678  -   1
			5889  -   2
			8888  -   4
			989990  - 1
*/

public class task63 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        int result = 0;

        while(a != 0) {
            if (a % 10 == 8) {
                result++;
            }
            a /= 10;
        }
        System.out.println(result);
    }
}
