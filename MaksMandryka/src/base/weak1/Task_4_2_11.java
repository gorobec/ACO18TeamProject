package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 *  Написать программу, которая при вводе числа в диапазоне от 1 до 99
 добавляет к нему слово "копейка" в правильной форме. Например, 1
 копейка, 5 копеек, 42 копейки .
 */
public class Task_4_2_11 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Number = sc.nextInt();

        if (Number > 4 && Number < 21) {
            System.out.println(Number + " Копеек");
        } else if (Number%10 == 1 ){
            System.out.println(Number + " Копейка");
        } else if (Number%10 == 2 || Number%10 == 3 || Number%10 == 4 ){
            System.out.println(Number + " Копейки");
        } else {
            System.out.println(Number + " Копеек");
        }
        sc.close();
    }
}
