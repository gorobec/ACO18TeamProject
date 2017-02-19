package oop.week3.task_2_SingleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static A<String> createStringList() {
        A<String> head = new Node<>("A");
        A<String> second = new Node<>("B");
        A<String> third = new Node<>("C");
        A<String> fourth = new Node<>("D");
        A<String> fifth = new Node<>("E");
        A<String> sixth = new Node<>("F");
        A<String> seventh = new Node<>("G");
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
        return head;
    }

    public static<T> A<T> reversion(A<T> head) {

        A<T> curr = head;
        A<T> iterator = null;

        while (curr != null) {
            A<T> next = curr.getNext();
            curr.setNext(iterator);
            iterator = curr;
            curr = next;
        }

        head = iterator;

        return head;
    }

}
