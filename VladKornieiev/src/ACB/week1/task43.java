package ACB.week1;

import java.util.Scanner;

/*
4.3. Пользователь вводит число.
Вывести на экран его удвоенное значение, если число делится на 7 нацело.
*/
public class task43 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (num % 7 == 0) {
            System.out.println(num*2);
        }
    }
}
