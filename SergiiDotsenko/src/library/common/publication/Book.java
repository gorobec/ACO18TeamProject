package library.common.publication;

public abstract class Book implements Publication {
    private PublicationType publicationType;
    private String author;
    private int year;
    private boolean onHands = false;
    private static int totalBooks = 0;
    private int bookID;

    public Book(){}

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
}