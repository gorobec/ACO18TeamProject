package biblio;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Journal extends Edition {
    private String name;
    private int number;
    private int year;
    private boolean isHave;

    public Journal(String namePublisher, String name, int number, int year) {
        super(namePublisher);
        this.name = name;
        this.number = number;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", year=" + year +
                '}';
    }
}


