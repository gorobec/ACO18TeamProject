package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class Magazine extends Edition {
    private int month;

    public Magazine(String name, String redactor, int year, int month, int number) {
        super(name, redactor, year, number);
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return String.format("Magazine: name - %20s, redactor - %10s, year - %5d, month - %3d, number - %3d", getName(), getAuthor(),
                getYear(),month, getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Magazine magazine = (Magazine) o;

        if (month == magazine.month) return super.equals(o);
        return false;

    }

}
