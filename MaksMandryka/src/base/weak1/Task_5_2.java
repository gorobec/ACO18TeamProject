package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 10.12.2016.
 * Вычислить факториал числа.
 */
public class Task_5_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long Num = sc.nextLong();

        System.out.println(Fact(Num));
    }

    public static long Fact(long Num){
        if (Num>1) {
            return Num*Fact(Num-1);
        } else {
            return 1;
        }
    }
}
