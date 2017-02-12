package oop.library;

import oop.library.controller.Library;
import oop.library.model.*;
import oop.dataStructures.MyArrayList;
import oop.dataStructures.MyList;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Администратор on 07.02.2017.
 */
public class LibraryTest {

    Library lib;
    Reader r1 = new Reader("Max", "Mandryka", new GregorianCalendar(2005, 10, 20));
    Reader r2 = new Reader("Stas", "Miroshnik", new GregorianCalendar(2003, 1, 20));
    Reader r3 = new Reader("Alex", "Porter", new GregorianCalendar(2001, 4, 20));
    Reader r4 = new Reader("Serhii", "Koval", new GregorianCalendar(2000, 6, 20));
    Reader r5 = new Reader("Max", "Mandryka", new GregorianCalendar(2006, 10, 20));
    Reader r6 = new Reader("Maks", "Mandryka", new GregorianCalendar(2006, 10, 20));
    String[] authors1 = {"Bloch, Joshua"};
    String[] authors2 = {"Толкин Джон Рональд Руэл"};
    String[] authors3 = {"Шевченко Тарас"};
    String[] authors4 = {"Ильф Илья", "Петров Евгений"};
    String[] authors5 = {"Автор Forbes1", "Автор Forbes2", "Автор Forbes3", "Автор Forbes4", "Автор Forbes5"};
    String[] authors6 = {"Автор Vogue1", "Автор Vogue2", "Автор Vogue3", "Автор Vogue4", "Автор Vogue5"};
    String[] authors7 = {"Автор НТ1", "Автор НТ2", "Автор НТ3", "Автор НТ4", "Автор НТ5"};
    String[] authors8 = {"Автор ВС1", "Автор ВС2", "Автор ВС3", "Автор ВС4", "Автор ВС5"};
    String[] authors9 = {"Автор ФиК1", "Автор ФиК2", "Автор ФиК3", "Автор ФиК4", "Автор ФиК5"};
    String[] authors10 = {"Автор Сегодня1", "Автор Сегодня2", "Автор Сегодня3", "Автор Сегодня4", "Автор Сегодня5"};
    String[] authors11 = {"Автор ВіК1", "Автор ВіК2", "Автор ВіК3", "Автор ВіК4", "Автор ВіК5"};
    String[] authors12 = {"Автор УМ1", "Автор УМ2", "Автор УМ3", "Автор УМ4", "Автор УМ5"};
    Book.Genres[] g1 = {Book.Genres.GUIDE};
    Book.Genres[] g2 = {Book.Genres.ACTION_AND_ADVENTURE, Book.Genres.FANTASY, Book.Genres.CHILDREN};
    Book.Genres[] g3 = {Book.Genres.POETRY};
    Book.Genres[] g4 = {Book.Genres.ROMANCE, Book.Genres.SATIRE};

    PrintedEdition pe1 = new Book("Effective Java", authors1, "Addison-Wasley", new GregorianCalendar(2008, 5, 01), "ENG", "USA", "A5", 346, 100000, g1);
    PrintedEdition pe2 = new Book("Хоббит, или Туда и обратно", authors2, "Азбука", new GregorianCalendar(2000, 01, 01), "RU", "Россия", "A5", 416, 7000, g2);
    PrintedEdition pe3 = new Book("Кобзар", authors3, "Веско", new GregorianCalendar(2013, 01, 01), "UA", "Україна", "145х200", 624, 1000, g3);
    PrintedEdition pe4 = new Book("Двенадцать стульев", authors4, "Астрель, АСТ", new GregorianCalendar(2011, 01, 01), "RU", "Россия", "130х200", 608, 3000, g4);
    PrintedEdition pe5 = new Journal("Forbes", authors5, "UMH group", new GregorianCalendar(2016, 04, 01), "RU", "Україна", "A4", 80, 10000,"Month", "фінанси, економіка");
    PrintedEdition pe6 = new Journal("Vogue", authors6, "Медиа Группа Украина", new GregorianCalendar(2017, 02, 01), "RU", "Україна", "A4", 120, 15000,"Month", "Мода");
    PrintedEdition pe7 = new Journal("Наука и техника", authors7, "Наука и Техника", new GregorianCalendar(2017, 01, 01), "RU", "Україна", "A4", 96, 15000,"Month", "научно-популярный, технический");
    PrintedEdition pe8 = new Journal("Вокруг света", authors8, "ООО «Издательство „Вокруг света“»", new GregorianCalendar(2016, 07, 01), "RU", "Россия", "A4", 126, 1000,"Month", "научно-популярный");
    PrintedEdition pe9 = new Magazine("Факты и комментарии", authors9, "EastOne Group", new GregorianCalendar(2016, 11, 11), "RU", "Україна", "A3", 16, 200000,"Day", "общественно-политическое издание");
    PrintedEdition pe10 = new Magazine("Сегодня", authors10, "ЧАО «Сегодня Мультимедиа»", new GregorianCalendar(2017, 01, 23), "RU", "Україна", "A3", 16, 233000,"Day", "общественно-политическое издание");
    PrintedEdition pe11 = new Magazine("Вісник і К", authors11, "А-Прінт", new GregorianCalendar(2016, 11, 11), "UA", "Україна", "A3", 20, 65000,"Week", "інформаційно-аналітичне видання");
    PrintedEdition pe12 = new Magazine("Україна молода", authors12, "ПП «Україна молода»", new GregorianCalendar(2016, 11, 11), "UA", "Україна", "A3", 16, 70000,"Day", "общественно-политическое издание");


    @Before
    public void setUp() {

        //Pattern Singleton, обновление библеотеки для каждого теста
        lib = Library.getInstance();
        lib.close();
        lib = Library.getInstance();

        lib.addReader(r1);
        lib.addReader(r2);
        lib.addReader(r3);
        lib.addReader(r4);
        lib.addReader(r5);
        lib.addReader(r6);

        lib.addPrintedEdition(pe1);
        lib.addPrintedEdition(pe2);
        lib.addPrintedEdition(pe3);
        lib.addPrintedEdition(pe4);
        lib.addPrintedEdition(pe5);
        lib.addPrintedEdition(pe6);
        lib.addPrintedEdition(pe7);
        lib.addPrintedEdition(pe8);
        lib.addPrintedEdition(pe9);
        lib.addPrintedEdition(pe10);
        lib.addPrintedEdition(pe11);
        lib.addPrintedEdition(pe12);
    }


    @Test
    public void testGetReaders() {
        MyList<Reader> list = new MyArrayList<>();
        assertTrue(list.add(r4));
        assertTrue(list.add(r6));
        assertTrue(list.add(r1));
        assertTrue(list.add(r5));
        assertTrue(list.add(r2));
        assertTrue(list.add(r3));

        MyList<Reader> list2 = lib.getReaders();

        assertEquals(list.get(0), list2.get(0));
        assertEquals(list.get(1), list2.get(1));
        assertEquals(list.get(2), list2.get(2));
        assertEquals(list.get(3), list2.get(3));
        assertEquals(list.get(4), list2.get(4));
        assertEquals(list.get(5), list2.get(5));
    }

    @Test
    public void testGetAvailablePrintEdit() {
        MyList<PrintedEdition> list = new MyArrayList<>();
        assertTrue(list.add(pe1));
        assertTrue(list.add(pe5));
        assertTrue(list.add(pe6));
        assertTrue(list.add(pe8));
        assertTrue(list.add(pe11));
        assertTrue(list.add(pe4));
        assertTrue(list.add(pe3));
        assertTrue(list.add(pe7));
        assertTrue(list.add(pe10));
        assertTrue(list.add(pe12));
        assertTrue(list.add(pe9));
        assertTrue(list.add(pe2));


        MyList<PrintedEdition> list2 = lib.getAvailablePrintEditList();

        assertEquals(list.get(0), list2.get(0));
        assertEquals(list.get(1), list2.get(1));
        assertEquals(list.get(2), list2.get(2));
        assertEquals(list.get(3), list2.get(3));
        assertEquals(list.get(4), list2.get(4));
        assertEquals(list.get(5), list2.get(5));
        assertEquals(list.get(6), list2.get(6));
        assertEquals(list.get(7), list2.get(7));
        assertEquals(list.get(8), list2.get(8));
        assertEquals(list.get(9), list2.get(9));
        assertEquals(list.get(10), list2.get(10));
        assertEquals(list.get(11), list2.get(11));

    }

    @Test
    public void testGivePrintEdit() {
        MyList<PrintedEdition> list = new MyArrayList<>();
        assertTrue(list.add(pe1));
        assertTrue(list.add(pe3));
        assertTrue(list.add(pe2));

        assertTrue(lib.givePrintEdit(r6, pe1));
        assertTrue(lib.givePrintEdit(r6, pe2));
        assertTrue(lib.givePrintEdit(r6, pe3));
        assertFalse(lib.givePrintEdit(r6, pe4));

        lib.addReaderToBlackL(r1);
        assertFalse(lib.givePrintEdit(r6, pe5));
        assertFalse(lib.givePrintEdit(r6, pe6));
        assertFalse(lib.givePrintEdit(r6, pe7));
        assertFalse(lib.givePrintEdit(r6, pe8));

        MyList<PrintedEdition> list2 = lib.getTakenPrintEditList(r6);

        assertEquals(list.get(0), list2.get(0));
        assertEquals(list.get(1), list2.get(1));
        assertEquals(list.get(2), list2.get(2));

    }

    @Test
    public void testGetFindMethods() {

        MyList<PrintedEdition> list2 = lib.getPrintEditByAuthor("Ильф Илья");
        MyList<PrintedEdition> list3 = lib.getPrintEditByMatch("и");
        MyList<PrintedEdition> list4 = lib.getPrintEditOfYear(2017);

        assertEquals(pe4, list2.get(0));
        assertEquals(pe11, list3.get(0));
        assertEquals(pe7, list3.get(1));
        assertEquals(pe9, list3.get(2));
        assertEquals(pe2, list3.get(3));
        assertEquals(pe6, list4.get(0));
        assertEquals(pe7, list4.get(1));
        assertEquals(pe10, list4.get(2));

    }
}
