package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */

import data_structures.MyArrayList;

import java.util.GregorianCalendar;

/**
 * Created by Kseniya on 30.01.2017.
 */
public class Reader {
    private int id;
    private String name;
    private String surname;
    private GregorianCalendar birthday;
    private MyArrayList editions;
    private boolean isInBlackList;
    private static final int MAX_BOOK_TO_HAVE = 3;


    public Reader(int id, String name, String surname, int year, int month, int day) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = new GregorianCalendar(year, month-1, day);
        this.editions = new MyArrayList();
    }

    public String toString(){
        return String.format("ID - %d, name - %10s, surname - %10s, birthday - %10tF ",id, name, surname, birthday);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public int getId(){ return id; }

    public boolean isInBlackList() { return isInBlackList; }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Reader reader = (Reader) object;

        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        if (surname != null ? !surname.equals(reader.surname) : reader.surname != null) return false;
        return birthday != null ? birthday.equals(reader.birthday) : reader.birthday == null;

    }

    @Override
    public int hashCode() {
        return 0;
    }

    public boolean addEdition(Edition edition) {
        if (isInBlackList || editions.size() >= MAX_BOOK_TO_HAVE) {return false;}
        return editions.add(edition);
    }

    public int getNumberOfEditions(){
        return editions.size();
    }

    public void showEditions() {
        for (int i = 0; i < editions.size(); i++)
            System.out.println(editions.get(i));
    }
}
