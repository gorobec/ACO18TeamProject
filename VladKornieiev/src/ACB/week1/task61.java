package ACB.week1;

import java.util.Scanner;

/*
Перевод с числа с десятичной системы счисления в двоичную, и наоборот.
Пользователь сам вводит число
*/

public class task61 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
                
        String output = "";

        System.out.print("Convert to binary or decimal? (B/D): ");
        String answer = sc.next();

        // converting to binary
        if (answer.equals("B")) {

            while (true) {
                if (number == 0) {
                    break;
                } else if (number % 2 == 0) {
                    output += '0';
                } else if (number % 2 == 1) {
                    output += '1';
                }
                number /= 2;
            }

            output = new StringBuffer(output).reverse().toString();
            System.out.println(output);
        }
        // converting to decimal
        else if (answer.equals("D")) {
            int result = 0;
            int i = 0;
            while (number != 0) {
                if (number % 10 != 0) {
                    result += Math.pow(2, i);
                }
                i++;
                number /= 10;
            }
            System.out.println(result);
        }
    }
}