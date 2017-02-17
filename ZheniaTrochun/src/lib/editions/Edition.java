package editions;

import utils.EditionType;

/**
 * Created by zhenia on 03.02.17.
 */
public abstract class Edition implements java.lang.Comparable {
    protected String name;
    protected String author;
    protected int year;
    protected EditionType type;

    public Edition(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
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

    public EditionType getType() {
        return type;
    }

    @Override
    public int compareTo(Object o){
        return this.name.compareTo(((Edition)o).name);
    }

    public int compareByAuthor(Edition e){
        return e.author.compareTo(this.author);
    }

    public int compareByType(Edition e){
        if(e.type.getVal() == this.type.getVal()) return 0;

        return e.type.getVal() > this.type.getVal() ? 1 : -1;
    }

    @Override
    public boolean equals(Object o){
        return ((Edition)o).name.equals(this.name) && ((Edition)o).author.equals(this.author);
    }

    @Override
    public abstract String toString();
}
