package oop.weak1.task_7_arrayList;

/**
 * Created by fmandryka on 27.01.2017.
 */
public class Run {
    public static void main(String[] args) {


        Object[] arr1 = {"Cat", "Dog", "Horse", "Mouse", "Rabbit", "Wolf", "Lion", "Pig"};

        MyArrayList myAL1 = new MyArrayList();
        MyArrayList myAL2 = new MyArrayList(10);
        MyArrayList myAL3 = new MyArrayList(arr1);

        System.out.println(myAL3.add(null) + " " + myAL3.toString());
        System.out.println(myAL3.remove(null) + " " + myAL3.toString());
        System.out.println(myAL3.add("Tiger") + " " + myAL3.toString());
        System.out.println(myAL3.add(2, "Monkey") + " " + myAL3.toString());
        System.out.println(myAL3.add(0, "Duck") + " " + myAL3.toString());
        System.out.println(myAL3.get(2) + ".... " + myAL3.toString());
        System.out.println(myAL3.remove(2) + " " + myAL3.toString());
        System.out.println(myAL3.remove("Wolf") + " " + myAL3.toString());
        System.out.println(myAL3.set(6, "Wolf") + " " + myAL3.toString());
        System.out.println(myAL3.contains("Wolf") + " " + myAL3.toString());
        myAL3.trimToSize();
        System.out.println(myAL3.toString());
        System.out.println(myAL3.size() + " " + myAL3.toString());
        myAL3.clear();
        System.out.println(myAL3.size() + " " + myAL3.toString());

        MyArrayList myAL4 = new MyArrayList(arr1);

    }
}
