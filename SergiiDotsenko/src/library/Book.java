package library;

public class Book implements Publication {
    private PublicationType publicationType;
    private String author;
    private int year;
    private static int totalBooks = 0;
    private int bookID;
    private int readerID = 0;//reader that reads this book, 0 - nobody reads

    public Book() {
    }

    public Book(PublicationType publicationType, String author, int year) {
        this.publicationType = publicationType;
        this.author = author;
        this.year = year;
        bookID = ++totalBooks;

    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    private String getStringPublicationType() {
        PublicationType[] publicationsString = PublicationType.values();
        return String.valueOf(publicationsString[publicationType.ordinal()]);
    }

    public void printPublicationType() {
        System.out.println("my type is \'" + getStringPublicationType() + "\'");
    }

    public void printFullInfo() {
        System.out.println(String.format("the bookID is %d, author is %s, year is %d, book kind is \'%s\'", bookID, author, year, getStringPublicationType()));
    }

    public boolean give(int readerID) {
        if (this.readerID == readerID || this.readerID > 0) {
            return false;
        }
        this.readerID = readerID;
        return true;
    }

    public int getReaderID() {
        return readerID;
    }

    public boolean onHands() {
        return readerID > 0;
    }

    public String getAuthor() {
        return author;
    }
}