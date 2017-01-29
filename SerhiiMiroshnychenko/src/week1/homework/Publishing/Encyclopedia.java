package week1.homework.Publishing;

/**
 * Created by serhiim on 26-Jan-17.
 */
public class Encyclopedia extends Book {

    public Encyclopedia(String name, int pages) {
        super(name, pages);
    }
    @Override
    public String getClassName(){
        return "Encyclopedia";
    }
    @Override
    public int getPageCount(){
        return this.pagesCount;
    }

    @Override
    public String getBookName (){
        return name;
    }
}
