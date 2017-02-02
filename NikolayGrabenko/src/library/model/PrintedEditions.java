package library.model;

public class PrintedEditions extends Editions {


    private int numberOfCopiesAvailable;
    private int numberOfCopiesAtReader;
    private int numberOfPages;

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

    public int getNumberOfCopiesAtReader() {
        return numberOfCopiesAtReader;
    }

    public void setNumberOfCopiesAtReader(int numberOfCopiesAtReader) {
        this.numberOfCopiesAtReader = numberOfCopiesAtReader;
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
                    && edition.getPublicationYear() == this.getPublicationYear()) ;
            return true;
        }
        return false;
    }
}
