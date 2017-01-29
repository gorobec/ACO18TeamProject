package ACB.week1;

import java.util.Scanner;

/*
1) Ввести с клавиатуры значения трех сторон треугольника a, b и c и опреде-
лить, является ли он прямоугольным. Ответ вывести в виде сообщения.
*/
public class task51 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b, c;
        System.out.print("Enter 1st side: ");
        a = sc.nextDouble();
        System.out.print("Enter 2nd side: ");
        b = sc.nextDouble();
        System.out.print("Enter 3rd side: ");
        c = sc.nextDouble();

        if (a*a + b*b == c*c || c*c + a*a == b*b || c*c + b*b == a*a) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
