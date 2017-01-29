package ACB.week1;

import java.util.Scanner;

/*
Определить, является ли шестизначное число "счастливым" (сумма
первых трех цифр равна сумме последних трех цифр).
*/

public class task57 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 6-ditigs number: ");
        int num = sc.nextInt();

        int left = num / 1000;
        int right = num % 1000;
        int sumleft = 0;
        int sumright = 0;

        for(int i = 0; i < 3; i++) {
            sumleft += left%10;
            sumright += right%10;
            left /= 10;
            right /= 10;
        }

        if (sumleft == sumright) {
            System.out.println("Lucky number!");
        }
    }

}
