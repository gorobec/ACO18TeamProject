package mainLib;

import editions.Edition;
import customer.Customer;
import interfaces.LibFunctionality;
import utils.NameComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhenia on 03.02.17.
 */
public class Library implements LibFunctionality{
    //private Customer[] customers;
    private ArrayList<Customer> customers;
    //private Edition[] editions;
    private  ArrayList<Edition> editions;
    //private Edition[] borrowedEditions = new Edition[0];
    private ArrayList<Edition> borrowedEditions = new ArrayList<>();
    //private Customer[] blackList = new Customer[0];
    private ArrayList<Customer> blackList = new ArrayList<>();

    private static final int MAX_CUSTOMERS_NUM = 1024;
    private static final int MAX_EDITIONS_NUM = 1024;

    public Library() {
        //customers = new Customer[0];
        //editions = new Edition[0];
        customers = new ArrayList<>();
        editions = new ArrayList<>();
    }

    public Library(Customer[] customers, Edition[] editions) {
        this.customers = new ArrayList<>();
        this.editions = new ArrayList<>();
        for (int i = 0; i < customers.length; i++) {
            this.customers.add(customers[i]);
        }

        for (int i = 0; i < editions.length; i++) {
            this.editions.add(editions[i]);
        }
    }

    private void sortAllByName(){
        //Arrays.sort(customers);
        //Arrays.sort(borrowedEditions);
        //Arrays.sort(editions);
        customers.sort(new NameComparator());
        borrowedEditions.sort(new NameComparator());
        editions.sort(new NameComparator());
    }

    public int indexOfCustomer(Customer customer){
        if(customer == null) return -1;

        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).equals(customer)) return i;
        }

        return -1;
    }

    public int indexOfEdition(Edition edition){
        if(edition == null) return -1;

        for (int i = 0; i < editions.size(); i++) {
            if(editions.get(i).equals(edition)) return i;
        }

        return -1;
    }

    /*public void addToBorrowed(Edition edition){
        Edition[] arr = new Edition[borrowedEditions.length + 1];

        System.arraycopy(borrowedEditions, 0, arr, 0, borrowedEditions.length);
        arr[borrowedEditions.length] = edition;
        borrowedEditions = arr;
    }*/

    @Override
    public void showCustomersList() {
        System.out.println("Customers");

        //Arrays.sort(customers);
        customers.sort(new NameComparator());

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(String.format("[%d] %s", i, customers.get(i).toString()));
        }
    }

    @Override
    public void showEditionsList() {
        System.out.println("Editions");

        //Arrays.sort(editions);
        editions.sort(new NameComparator());

        for (int i = 0; i < editions.size(); i++) {
            System.out.println(String.format("[%d] %s", i, editions.get(i).toString()));
        }
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customer == null) return false;

        if(customers.size() >= MAX_CUSTOMERS_NUM) return false;

        if(indexOfCustomer(customer) != -1) return false;

        /*Customer[] arr = new Customer[customers.length + 1];

        System.arraycopy(customers, 0, arr, 0, customers.length);
        arr[customers.length] = customer;
        customers = arr;*/

        customers.add(customer);

        return true;
    }

    @Override
    public boolean addEdition(Edition edition) {
        if(edition == null) return false;

        if(editions.size() >= MAX_EDITIONS_NUM) return false;

        if(indexOfEdition(edition) != -1) return false;

        /*Edition[] arr = new Edition[editions.length + 1];

        System.arraycopy(editions, 0, arr, 0, editions.length);
        arr[editions.length] = edition;
        editions = arr;*/

        editions.add(edition);

        return true;
    }

    @Override
    public boolean giveEdition(Customer customer, Edition edition) {
        if(edition == null || customer == null) return false;

        int editionIndex = indexOfEdition(edition);
        int customerIndex = indexOfCustomer(customer);

        if(customerIndex == -1 || editionIndex == -1) return false;

        if(!customers.get(customerIndex).borrowEdition(edition)) return false;

        //addToBorrowed(edition);

        borrowedEditions.add(edition);

        /*Edition[] arr = new Edition[editions.length - 1];

        System.arraycopy(editions, 0, arr, 0, editionIndex);
        System.arraycopy(editions, editionIndex + 1, arr, editionIndex, editions.length - editionIndex - 1);
        editions = arr;*/

        editions.remove(editionIndex);

        return true;
    }

    @Override
    public void showBorrowedEditions() {
        //Arrays.sort(borrowedEditions);
        borrowedEditions.sort(new NameComparator());
        for (int i = 0; i < borrowedEditions.size(); i++) {
            System.out.println(String.format("[%d] %s", i, borrowedEditions.get(i).toString()));
        }
    }

    @Override
    public void showBorrowedEditions(Customer customer) {
        if(customer == null) return;

        Edition[] arr = customer.getBorrowed();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.format("[%d] %s", i, arr[i].toString()));
        }
    }

    @Override
    public boolean addToBlackList(Customer customer) {
        if(customer == null) return false;

        int customerIndex = indexOfCustomer(customer);

        if(customerIndex == -1) return false;

        /*Customer[] black = new Customer[blackList.length + 1];

        System.arraycopy(blackList, 0, black, 0, blackList.length);
        black[blackList.length] = customers[customerIndex];
        blackList = black;

        Customer[] arr = new Customer[customers.length - 1];

        System.arraycopy(customers, 0, arr, 0, customerIndex);
        System.arraycopy(customers, customerIndex + 1, arr, customerIndex, customers.length - customerIndex - 1);
        customers = arr;*/


        blackList.add(customers.remove(customerIndex));

        return true;
    }

    @Override
    public void showEditionsByAuthor(String author) {
        //Arrays.sort(editions);
        editions.sort(new NameComparator());

        for (int i = 0; i < editions.size(); i++) {
            if(editions.get(i).getAuthor().equals(author)) System.out.println(
                    String.format("[%d] %s", i, editions.get(i).toString())
            );
        }
    }

    @Override
    public void showEditionsByYear(int year) {
        //Arrays.sort(editions);
        editions.sort(new NameComparator());

        for (int i = 0; i < editions.size(); i++) {
            if(editions.get(i).getYear() == year) System.out.println(
                    String.format("[%d] %s", i, editions.get(i).toString())
            );
        }
    }

    @Override
    public Edition getEditionByName(String name) {
        //Arrays.sort(editions);
        editions.sort(new NameComparator());

        for (int i = 0; i < editions.size(); i++) {
            if(editions.get(i).getName().equals(name)) return editions.get(i);
        }

        return null;
    }

    @Override
    public Edition getEditionByIndex(int index) {
        return editions.get(index);
    }

    @Override
    public Customer getCustomerByNameAndAge(String name, int age) {
        //Arrays.sort(customers);
        customers.sort(new NameComparator());

        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName().equals(name) && customers.get(i).getAge() == age) return customers.get(i);
        }

        return null;
    }
}
