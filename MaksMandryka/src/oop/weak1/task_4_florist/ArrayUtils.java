package oop.weak1.task_4_florist;

import oop.weak1.university.Student;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class ArrayUtils {

    public static Flower[] addElement(Flower[] flowers, Flower flower) {

        Flower[] flowersNew = new Flower[flowers.length + 1];
        System.arraycopy(flowers, 0, flowersNew, 0, flowers.length);
        flowersNew[flowers.length] = flower;
        return flowersNew;
    }

}
