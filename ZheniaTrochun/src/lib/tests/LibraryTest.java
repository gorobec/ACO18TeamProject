package tests;

import customer.Customer;
import editions.Book;
import editions.Edition;
import editions.Magazine;
import editions.Newspaper;
import mainLib.Library;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhenia on 03.02.17.
 */
public class LibraryTest {
    private Library lib;

    @Before
    public void setUp(){
        Customer[] customers = new Customer[5];

        customers[0] = new Customer("Dmitrii", 20);
        customers[1] = new Customer("Anna", 19);
        customers[2] = new Customer("Aleksei", 21);
        customers[3] = new Customer("Evgenii", 19);
        customers[4] = new Customer("Vova", 18);

        Edition[] editions = new Edition[5];

        editions[0] = new Book("Matan", "Bodnarchuk", 2017);
        editions[1] = new Book("Teorver", "Pavlov", 2016);
        editions[2] = new Magazine("Nauka", "USSR", 1970);
        editions[3] = new Newspaper("Times", "GB", 2010);
        editions[4] = new Book("C", "Shtraustrop", 2011);

        lib = new Library(customers, editions);
    }

    @Test
    public void testOutput(){
        lib.showCustomersList();
        lib.showEditionsList();
        lib.showEditionsByAuthor("GB");
        lib.showEditionsByYear(2017);
    }

    @Test
    public void testAddMethods(){
        Assert.assertTrue(lib.addCustomer(new Customer("Valentin", 18)));
        Assert.assertTrue(lib.addEdition(new Book("History", "Pilipaka", 2016)));

        for (int i = 0; i < 1024; i++) {
            lib.addCustomer(new Customer("Valentin" + i, 18));
        }

        Assert.assertFalse(lib.addCustomer(new Customer("Valentin", 18)));
    }

    @Test
    public void testBorrowingMethods(){
        Assert.assertTrue(lib.giveEdition(new Customer("Anna", 19), lib.getEditionByName("C")));
        lib.showEditionsList();
        lib.showBorrowedEditions();
        lib.showBorrowedEditions(lib.getCustomerByNameAndAge("Anna", 19));
        Assert.assertTrue(
                lib.addEdition(
                        lib.getCustomerByNameAndAge("Anna", 19).returnEdition(0)));
        lib.showEditionsList();
    }

    @Test
    public void testBlackList(){
        Assert.assertTrue(lib.addToBlackList(lib.getCustomerByNameAndAge("Anna", 19)));
        lib.showCustomersList();
    }
}
