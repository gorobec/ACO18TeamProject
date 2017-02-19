package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Journal extends Edition {
    private int number;
    private int year;

    public Journal(String name, int kolvo, int number, int year) {
        super(name, kolvo);
        this.number = number;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return super.toString() + "Journal{" +
                "number=" + number +
                ", year=" + year +
                '}';
    }
}


