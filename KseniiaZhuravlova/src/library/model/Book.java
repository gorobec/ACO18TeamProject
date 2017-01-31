package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class Book implements Edition{
    private String name;
    private String author;
    private int year;
    private int number;

    public Book(String name, String author, int year, int number) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }


    @Override
    public boolean isAvaible() {
        return number>0;
    }

    @Override
    public String toString() {
        return String.format("Book: name - %30s, author - %20s, year - %5d, number - %3d", name, author, year, number);
    }

}

