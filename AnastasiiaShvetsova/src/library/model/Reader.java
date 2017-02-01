package library.model;

import data_structures.MyArrayList;
import library.model.PrintEdition;
import library.controller.Library;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Reader {
    private String name;
    private String surname;
    private int age;
    private int countPrintEditions = 0;
    private MyArrayList readerPrintEditions;

    public Reader(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.readerPrintEditions = new MyArrayList();
    }

    public boolean addPrintEditionForReader(PrintEdition printEdition) {
        readerPrintEditions.add(printEdition);
        countPrintEditions++;
        return true;
    }

    public MyArrayList getReaderPrintEditions() {
        return readerPrintEditions;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String showReaderPrintEditions() {
        return readerPrintEditions.toString();
    }

    @Override
    public String toString() {
        return
                "{name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", age=" + age + "}";
    }

}
