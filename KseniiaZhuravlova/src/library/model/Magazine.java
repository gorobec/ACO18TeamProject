package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class Magazine implements Edition {
    private String name;
    private int year;
    private int month;
    private int number;
    private String redactor;

    public Magazine(String name, String redactor, int year, int month, int number) {
        this.name = name;
        this.redactor = redactor;
        this.year = year;
        this.month = month;
        this.number = number;
    }
    @Override
    public String getAuthor(){
        return redactor;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
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
        return number > 0;
    }

    @Override
    public String toString() {
        return String.format("Magazine: name - %20s, redactor - %10s, year - %5d, number - %3d", name, redactor, year, number);
    }

}
