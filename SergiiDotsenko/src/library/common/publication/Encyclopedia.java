package library.common.publication;

public class Encyclopedia extends Book {

    public Encyclopedia(){
        super();
    }

    public Encyclopedia(String author, int year) {
        super(PublicationType.Encyclopedia, author, year);
    }
}