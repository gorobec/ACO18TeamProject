package library.model;

/**
 * Created by serhiim on 29-Jan-17.
 */
public class PrintedEdition extends Edition{
    private String date;
    private String genre;
    private int copiesCount;

    public PrintedEdition() {

    }

    public PrintedEdition(String editionName, String editionAddress, String date, String genre, int copiesCount) {
        super(editionName, editionAddress);
        this.date = date;
        this.genre = genre;
        this.copiesCount = copiesCount;
    }

    public String getDate() {
        return date;
    }

    public String getGenre() {
        return genre;
    }

    public int getCopiesCount() {
        return copiesCount;
    }

}
