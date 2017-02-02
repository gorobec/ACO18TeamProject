package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public abstract class Edition {
    private String name;
    private String author;
    private int year;
    private int number;

    public Edition(String name, String author, int year, int number) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return number>0;
    }

    public void setNumber(int number) {
        this.number = number;
    }

 /*   public String toString() {
        return String.format("Edition: name - %30s, author - %20s, year - %5d, number - %3d", name, author, year, number);
    }*/

    public final String info() {
        return String.format("Name - %30s, author - %20s, year - %5d", name, author, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edition edition = (Edition) o;
        if (year != edition.year) return false;
        if (name != null ? !name.equals(edition.name) : edition.name != null) return false;
        return author != null ? author.equals(edition.author) : edition.author == null;

    }
}
