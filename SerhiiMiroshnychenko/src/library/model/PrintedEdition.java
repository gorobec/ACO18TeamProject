package library.model;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class PrintedEdition extends Edition{
    private String name;
    private String date;
    private String genre;
    private int copiesCount = 0;

    public PrintedEdition() {

    }

    public PrintedEdition(String editionName, String editionAddress, String name, String date, String genre, int copiesCount) {
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
    public String getGenre() {
        return genre;
    }

    public int getCopiesCount() {
        return copiesCount;
    }

    public void setCopiesCount(int copiesCount) {
        this.copiesCount = copiesCount;
    }
}
