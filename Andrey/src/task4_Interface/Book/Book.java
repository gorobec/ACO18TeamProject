package task4_Interface.Book;

/**
 * Created by Sherlock on 28.01.2017.
 */
public abstract class  Book implements Edition  {

    private String name;
    private  int year;


    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Deprecated
    public  void  showBook(){

        System.out.printf("Book name: %s . Place of publication - %s" , name, place );
    }
    public abstract void getBookType();
}

