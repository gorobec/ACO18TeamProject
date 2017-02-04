package library.model;

public class Magazine extends PrintedEditions {

    private int monthOfPublishing;

    public Magazine(String name, String author, int publicationYear, int numberOfCopies, int numberOfPages) {
        super(name, author, publicationYear, numberOfCopies, numberOfPages);
    }

    public Magazine(String name, String author, int numberOfCopiesAvailable,
                    int numberOfPages, int publicationYear, int monthOfPublishing) {
        super(name, author, publicationYear, numberOfCopiesAvailable, numberOfPages);
        this.monthOfPublishing = monthOfPublishing;
    }

    public Magazine(String name, int publicationYear, int monthOfPublishing) {
        super(name, publicationYear);
        this.monthOfPublishing = monthOfPublishing;
    }

    public final String info () {
        return String.format("Журнал - %15s, год издания - %6d  месяц издания  - %4d",this.getName(),
                this.getPublicationYear(),this.monthOfPublishing);
    }
}
