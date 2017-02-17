package interfaces;

import editions.Edition;
import customer.Customer;

/**
 * Created by zhenia on 03.02.17.
 */
public interface LibFunctionality {
    void showCustomersList();
    void showEditionsList();
    boolean addCustomer(Customer customer);
    boolean addEdition(Edition edition);
    boolean giveEdition(Customer customer, Edition edition);
    void showBorrowedEditions();
    void showBorrowedEditions(Customer customer);
    boolean addToBlackList(Customer customer);
    void showEditionsByAuthor(String author);
    void showEditionsByYear(int year);
    Edition getEditionByName(String name);
    Edition getEditionByIndex(int index);
    Customer getCustomerByNameAndAge(String name, int age);
}
