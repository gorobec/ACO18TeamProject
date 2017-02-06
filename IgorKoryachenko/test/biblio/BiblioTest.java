package biblio;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import week1.homeWork.implementAL.ArrList;
import static org.junit.Assert.*;

public class BiblioTest {
    Library library;
    ArrList readers;
    ArrList blackList;
    ArrList editions;

    Reader reader1;
    Reader reader2;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;
    Book book7;




    @Before
    public void setLibrary() {
         library = new Library();
         readers = new ArrList();
         blackList = new ArrList();
         editions = new ArrList();
         reader1 = new Reader("Ivanov", new ArrList());
         reader2 = new Reader("Petrov", new ArrList());

        book1 = new Book("Voina i mir", 10, "Tolstoy");
        book2 = new Book("Idiot", 52,  "Dostoevskiy");
        book3 = new Book("Palata №6", 32, "Chehov");
        book4 = new Book("Ovod", 10, "Voinich");
        book5 = new Book("Van`ka", 5, "Chehov");
        book6 = new Book("Chaika", 12, "Chehov");
        book7 = new Book("Kashtanka", 3, "Chehov");

        Journal journal1 = new Journal("Burda", 3, 12, 2012);
        Journal journal2 = new Journal("Playboby", 5, 5, 2002);
        Journal journal3 = new Journal("Elle", 11, 8, 2013);
        Journal journal4 = new Journal("Doyarka", 6, 3, 1960);
        Journal journal5 = new Journal("Doyarka", 2, 2, 1962);
        Journal journal6 = new Journal("Playboby", 12, 5, 2012);


    }

    @Ignore
    @Test
    public void testShowReaders(){
    library.getReaders().add(reader1);
    library.getReaders().add(reader2);


    String actual = "Surname - Ivanov\nSurname - Petrov\n";
        assertThat(library.showReaders(), is(actual));
    }

    @Test
    public void testAvailableEdition() throws Exception {

    }

    @Test
    public void testAddReader() throws Exception {
        boolean b = library.addReader(reader1);
        assertTrue(b);

    }

    @Test
    public void testIssueEdition() throws Exception {
        boolean b = library.issueEdition(reader1, book1);
        assertTrue(b);
    }
}
