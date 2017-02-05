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
    private ArrayList<PrintedEdition> takenItems = new ArrayList<>();
    private int currentItemsInHands = 0;
    private static final int MAX_ITEMS_IN_HANDS = 10;
    private static int counter = 1;
    public Reader() {
        libraryCardNumber = counter++;
    }

    public Reader(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        libraryCardNumber = counter ++;
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

    public ArrayList<PrintedEdition> getTakenItems() {
        return takenItems;
    }

    public void setTakenBooks(ArrayList<PrintedEdition> takenItems) {
        this.takenItems = takenItems;
    }

    public int getCurrentItemsInHands() {
        return currentItemsInHands;
    }

    public void setCurrentItemsInHands(int currentItemsInHands) {
        this.currentItemsInHands = currentItemsInHands;
    }

    public boolean takeItem(PrintedEdition item) {
        if (item == null || currentItemsInHands == MAX_ITEMS_IN_HANDS) return false;
        takenItems.add(item);
        currentItemsInHands++;
        return true;
    }

    public boolean returnItem(PrintedEdition item) {
        takenItems.remove(item);
        currentItemsInHands--;
        return true;
    }
}
