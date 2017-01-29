package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 10.12.2016.
 * Перевод с числа с десятичной системы счисления в двоичную, и наоборот. Пользователь сам вводит число
 */
public class Task_5_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); //Вводим число и основание через пробел
        long Num = sc.nextLong();
        int base = sc.nextInt();
        String Num2 = "";
        if (base == 10) {
            while (Num > 0) {
                Num2 = Num % 2 + Num2;
                Num /= 2;
            }
            System.out.println("Двоичная запись вашего числа " + Num2);
        }
        if (base == 2) {
            String NumString = "" + Num;
            Num = 0;
            for (int i = 0; i < NumString.length(); i++) {
                Num += Math.pow(2, NumString.length() - i - 1) * Integer.parseInt(Character.toString(NumString.charAt(i)));
            }
            Num2 = "" + Num;
            System.out.println("Десятичная запись вашего числа " + Num2);
        }
    }
}
