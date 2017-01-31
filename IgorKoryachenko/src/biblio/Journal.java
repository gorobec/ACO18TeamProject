package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Journal extends Edition {
    private int number;
    private int year;
    private int kolvo;

    public Journal(String name, int number, int year, int kolvo) {
        super(name);
        this.number = number;
        this.year = year;
        this.kolvo = kolvo;
    }

    @Override
    public String toString() {
        return super.toString() + "Journal{" +
                "number=" + number +
                ", year=" + year +
                '}';
    }
}


