package base.weak1;

/**
 * Created by Администратор on 09.12.2016.
 * Вычислить стоимость покупки с учетом скидки. Скидка в 10% предос-
 тавляется, если сумма покупки превышает 1000 гривен.
 */
public class Task_4_2_8 {
    public static void main(String args[]){
        double order = 10000;

        if (order > 1000) {
            System.out.println(order*0.9);
        } else{
            System.out.println(order);
        }

    }
}
