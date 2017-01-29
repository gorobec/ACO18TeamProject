package base.weak1;

import java.util.Scanner;

/**
 * Created by Администратор on 09.12.2016.
 * Известны площади круга и квадрата. Определить: а) уместится ли круг в
 квадрат; б) уместится ли квадрат в круге.
 */
public class Task_4_2_15 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double S1 = sc.nextDouble();
        double S2 = sc.nextDouble();

        if (S1>S2) {
            /** Находим максимальную площадь квадрата, который можно вписать в круг
             * площадь квадрата равна квадрату длины диагонали поделенному на два
             * площадь круга равна пи*r^2
             */
            double Smax = S1*4/Math.PI/2;
            if (S2<=Smax) {
                System.out.println("Квадрат можно вписать в круг");
            }
        } else {
            /** Находим максимальную площадь круга, который можно вписать в квадрат
             * площадь квадрата равна квадрату длины диагонали поделенному на два
             * площадь круга равна пи*r^2
             */
            double Smax = S2*2*Math.PI/4;
            if (S1<=Smax) {
                System.out.println("Круг можно вписать в квадрат");
            }
        }
        sc.close();
    }
}
