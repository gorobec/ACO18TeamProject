package library.model;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class PrintedEdition extends Edition {
    private String name;
    private String date;
    private Genre genre;
    private int copiesCount = 0;

    public PrintedEdition() {

    }

    public PrintedEdition(String editionName, String editionAddress, String name, String date, Genre genre, int copiesCount) {
        super(editionName, editionAddress);
        this.name = name;
        this.date = date;
        this.genre = genre;
        this.copiesCount = copiesCount;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getCopiesCount() {
        return copiesCount;
    }

    public void setCopiesCount(int copiesCount) {
        this.copiesCount = copiesCount;
    }

    public final String info() {
        return String.format("Name: %s, Genre: %s, Copies: %d, Edition name: %s, Publish Date: %s", name, genre, copiesCount, super.getEditionName(), date);
    }
}
