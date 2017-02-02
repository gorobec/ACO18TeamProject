package library.common.publication;

public class Directory extends Book {

    public Directory(){
        super();
    }
    public Directory(String author, int year) {
        super(PublicationType.Directory, author, year);
    }
}