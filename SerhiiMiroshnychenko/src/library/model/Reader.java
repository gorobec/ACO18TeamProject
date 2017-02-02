package library.model;

import week1.homework.arrayList.MyArrayList;

import java.util.ArrayList;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class Reader {
    private String firstName;
    private String lastName;
    private int age;
    private int libraryCardNumber;
    private ArrayList<Book> takenBooks = new ArrayList<>();
    private ArrayList<Magazine> takenMagazines = new ArrayList<>();
    private int currentItemsInHands;
    private static final int MAX_ITEMS_IN_HANDS = 10;

    public Reader() {
    }

    public Reader(String firstName, String lastName, int age, int libraryCardNumber, ArrayList<Book> takenBooks,
                  ArrayList<Magazine> takenMagazines, int currentItemsInHands) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.libraryCardNumber = libraryCardNumber;
        this.takenBooks = takenBooks;
        this.takenMagazines = takenMagazines;
        this.currentItemsInHands = currentItemsInHands;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public ArrayList<Book> getTakenBooks() {
        return takenBooks;
    }

    public void setTakenBooks(ArrayList<Book> takenBooks) {
        this.takenBooks = takenBooks;


    }

    public ArrayList<Magazine> getTakenMagazines() {
        return takenMagazines;
    }

    public void setTakenMagazines(ArrayList<Magazine> takenMagazines) {
        this.takenMagazines = takenMagazines;
    }

    public int getCurrentItemsInHands() {
        return currentItemsInHands;
    }

    public void setCurrentItemsInHands(int currentItemsInHands) {
        this.currentItemsInHands = currentItemsInHands;
    }

    public boolean takeBook(Book book) {
        if (book == null || currentItemsInHands == MAX_ITEMS_IN_HANDS) return false;
        takenBooks.add(book);
        currentItemsInHands++;
        return true;
    }

    public boolean takeMagazine(Magazine magazine) {
        if (magazine == null || currentItemsInHands == MAX_ITEMS_IN_HANDS) return false;
        takenMagazines.add(magazine);
        currentItemsInHands++;
        return true;
    }

    public boolean returnBook(Book book) {
        takenBooks.remove(book);
        currentItemsInHands--;
        return true;
    }

    public boolean returnBook(Magazine magazine) {
        takenMagazines.remove(magazine);
        currentItemsInHands--;
        return true;
    }


}
