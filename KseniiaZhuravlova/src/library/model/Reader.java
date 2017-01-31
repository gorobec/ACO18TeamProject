package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */

import data_structures.MyArrayList;

import java.util.GregorianCalendar;

/**
 * Created by Kseniya on 30.01.2017.
 */
public class Reader implements Comparable{
    private int id;
    private String name;
    private String surname;
    private GregorianCalendar birthday;
    private MyArrayList editions;


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

    @Override
    public int compareTo(Object student) {
        if (student == null || !(student instanceof Reader)) return -1;
        Reader temp = (Reader) student;
        return surname.compareTo(temp.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        if (surname != null ? !surname.equals(reader.surname) : reader.surname != null) return false;
        if (birthday != null ? !birthday.equals(reader.birthday) : reader.birthday != null) return false;
        return editions != null ? editions.equals(reader.editions) : reader.editions == null;

    }


    public boolean addEdition(Edition edition){
        if(editions.size()>=3) return false;
        editions.add(edition);
        return true;
    }

    public int getNumberOfEdition(){
        return editions.size();
    }

    public void showEditions() {
        for (int i = 0; i < editions.size(); i++)
            System.out.println(editions.get(i));
    }
}
