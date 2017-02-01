package library.model;

import java.util.GregorianCalendar;

/**
 * Created by User on 30.01.2017.
 */
public class PrintedEditions extends Editions {


    private int numberOfCopiesAvailable;
    private int numderOfCopiesAtReader =0;
    private int daysOfLoan;
    private int numberOfPages;
    private GregorianCalendar dateOfLoan;
    private GregorianCalendar dateOfReturn;

    public PrintedEditions(String name, String author, int publicationYear, int numberOfCopiesAvailable, int numberOfPages) {
        super(name, author, publicationYear);
        this.numberOfCopiesAvailable = numberOfCopiesAvailable;
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfCopiesAvailable() {
        return numberOfCopiesAvailable;
    }

    public void setNumberOfCopiesAvailable(int numberOfCopiesAvailable) {
        this.numberOfCopiesAvailable = numberOfCopiesAvailable;
    }

    public int getNumderOfCopiesAtReader() {
        return numderOfCopiesAtReader;
    }

    public void setNumderOfCopiesAtReader(int numderOfCopiesAtReader) {
        this.numderOfCopiesAtReader = numderOfCopiesAtReader;
    }

    public String showEdition() {
        return String.format("Name - %25s, Author - %25s, year of  publication - %6d",
                this.getName(), this.getAuthor(), this.getPublicationYear());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            PrintedEditions edition = (PrintedEditions) obj;
            if (edition.getName().equals(this.getName()) && edition.getAuthor().equals(this.getAuthor())
                    && edition.getPublicationYear() == this.getPublicationYear());
                return true;
        }
        return false;
    }
}
