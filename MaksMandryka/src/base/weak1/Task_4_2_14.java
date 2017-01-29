package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Определить, является ли шестизначное число "счастливым" (сумма
 первых трех цифр равна сумме последних трех цифр).
 */
public class Task_4_2_14 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Num = sc.nextInt();
        int F1 =Num/100000;
        int F2 =Num/10000%10;
        int F3 =Num/1000%10;
        int F4 =Num/100%10;
        int F5 =Num/10%10;
        int F6 =Num%10;

        if (F1+F2+F3==F4+F5+F6) {
            System.out.println("Число " + Num + " счастливое");
        } else {
            System.out.println("Число " + Num + " обычное");
        }
        sc.close();
    }
}
