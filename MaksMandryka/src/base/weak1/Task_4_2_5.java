package base.weak1;

/**
 * Created by Администратор on 09.12.2016.
 * Даны три числа a, b, c. Определить, имеется ли среди них хотя бы одна
 пара равных
 */
public class Task_4_2_5 {
    public static void main(String args[]){
        double a = 10;
        double b = 9.5;
        double c = 9.5;
        if (a==b || a==c || b==c) {
            System.out.println("Есть одинаковые числа");
        }
    }
}
