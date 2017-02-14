package week4.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TestAddingIntoLists {

    public static final int ACTION_COUNT = 1000;
    public static final int SIZE = 1000000;

    public static void main(String[] args) {

        List<Integer> nums1 = initArrayList(SIZE);
        List<Integer> nums2 = initLinkedList(SIZE);

        long time1 = calculateActionTime(new MyAction() {
            @Override
            public void process() {
                for (int i = 0; i < ACTION_COUNT; i++) {
                    nums1.add(nums1.size() / 2, 0);
                }
            }
        });

        long time2 = calculateActionTime(new MyAction() {
            @Override
            public void process() {

                for (int i = 0; i < ACTION_COUNT; i++) {
                    nums2.add(nums2.size() / 2, 0);
                }
            }
        });

        System.out.println(time1);
        System.out.println(time2);




    }

    private static List<Integer> initArrayList(int size) {

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(i);
        }

        return arr;
    }

    private static List<Integer> initLinkedList(int size) {

        List<Integer> arr = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            arr.add(i);
        }

        return arr;
    }

    public static long calculateActionTime(MyAction action){
        long start = System.nanoTime();
        action.process();
        long end = System.nanoTime();
        return end - start;
    }

}

interface MyAction {
    void process();
}