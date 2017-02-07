package ACO.week3.homework.java.ua.com.artcode;


import static org.junit.Assert.*;

import ACO.week3.homework.main.java.ua.com.artcode.A;
import ACO.week3.homework.main.java.ua.com.artcode.ListUtils;
import ACO.week3.homework.main.java.ua.com.artcode.Node;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestReversion {

    static A<Object> head;
    static A<Object> second;
    static A<Object> third;
    static A<Object> fourth;
    static A<Object> fifth;
    static A<Object> sixth;
    static A<Object> seventh;

    @BeforeClass
    public static void create() {
        head = new Node<>();
        second = new Node<>();
        third = new Node<>();
        fourth = new Node<>();
        fifth = new Node<>();
        sixth = new Node<>();
        seventh = new Node<>();
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
    }

    @Test
    public void testReversion(){

        A<Object> expected = seventh;
        A<Object> actual = ListUtils.reversion(head);
        assertSame(expected, actual);

        expected = sixth;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = fifth;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = fourth;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = third;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = second;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = head;
        actual = actual.getNext();
        assertSame(expected, actual);
    }

}
