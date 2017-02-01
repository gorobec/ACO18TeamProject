package library.model;

import library.utils.ArrayListMy;

/**
 * Created by User on 29.01.2017.
 */
public class Reader {

    private String name;
    private String surName;
    private int age;
    private String homeAddress;

    private int counterOfPrintEds;

    PrintedEditions edition;
    ArrayListMy readerEditions = new ArrayListMy();

    public ArrayListMy getReaderEditions() {
        return readerEditions;
    }

    public Reader(String name, String surName, int age, String homeAddress) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public int getCounterOfPrintEds() {
        return counterOfPrintEds;
    }

    public void setCounterOfPrintEds(int counterOfPrintEds) {
        this.counterOfPrintEds = counterOfPrintEds;
    }

    public String showReader() {
        return String.format("Name - %10s, Surname - %15s, age - %4d, Home address - %20s",
                this.getName(), this.getSurName(), this.getAge(), this.getHomeAddress());
    }

    public boolean isEditionInReaderList(PrintedEditions edition) {
        boolean isEditionInReaderList = false;
        if (edition != null) {
            for (int i = 0; i < readerEditions.size(); i++) {
                PrintedEditions editionTemp = (PrintedEditions) readerEditions.get(i);
                if (edition.equals(editionTemp)) {
                    isEditionInReaderList = true;
                    break;
                }
            }
        }
        return isEditionInReaderList;
    }

    public boolean addPrintedEditionToList(PrintedEditions edition) {
        boolean wasAdded = false;
        if (edition != null ) {
            readerEditions.add(edition);
            counterOfPrintEds ++;
            wasAdded = true;
        }
        return wasAdded;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Reader reader = (Reader) obj;
            if (reader.name.equals(this.name) && reader.surName.equals(this.surName) && reader.age == this.age)
                return true;
        }
        return false;
    }
}

