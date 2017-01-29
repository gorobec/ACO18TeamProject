package base.weak1;

/**
 * Created by Администратор on 09.12.2016.
 * Даны три числа A,B,C. Увеличить числа в два
 раза, если A+B+C>0, в противном случае заменить
 на нули.
 */
public class Task_4_2_13 {
    public static void main(String args[]){

        double A = 3;
        double B = -20.5;
        double C = 7.3;

        if (A+B+C>0) {
            A=A*2;
            B=B*2;
            C=C*2;
        } else {
            A=B=C=0;
        }

    }
}
