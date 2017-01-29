package ACO.week1.arraylist;

import java.util.ArrayList;

/**
 * Created by v21k on 25.01.17.
 */
public class Run {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(1);
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";


        // add test - OK
        System.out.println("ADD TEST");
        myArrayList.add(s1);
        myArrayList.showAll();
        myArrayList.add(s2);
        myArrayList.showAll();
        myArrayList.add(1,s3);
        myArrayList.showAll();
        System.out.println(myArrayList.size());
        System.out.println();

        // remove - OK
        System.out.println("REMOVE TEST");
        myArrayList.remove(2);
        myArrayList.remove(s3);
        myArrayList.showAll();
        System.out.println(myArrayList.size());
        System.out.println();

        // set - OK
        System.out.println("SET TEST");
        System.out.println(myArrayList.set(0,s3));
        System.out.println();
        myArrayList.showAll();

        // clear - OK
        System.out.println("clear TEST");
        myArrayList.clear();
        myArrayList.showAll();
        myArrayList.add(s1);
        myArrayList.add(1,s2);
        myArrayList.showAll();

        // contains - OK
        System.out.println(myArrayList.contains(s1));
        System.out.println(myArrayList.contains(s2));
        System.out.println(myArrayList.contains(s3));
        System.out.println(myArrayList.size());
    }
}
