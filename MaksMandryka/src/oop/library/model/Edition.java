package oop.library.model;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Edition {

    private String name;
    private String[] authorName;
    private String publisherName;
    private String editionDate;
    private String lang;
    private String country;

    int id;
    int readerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReaderId() {
        return readerId;
    }

    public boolean isAvailable(){
        if (readerId == 0) {
            return true;
        }
        return false;
    }
}
