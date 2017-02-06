package oop.library.model;

import java.util.Calendar;
import java.util.Comparator;


/**
 * Created by fmandryka on 31.01.2017.
 */
public class Edition implements Comparable<Object>{

    protected String name;
    protected String[] authorName;
    protected String publisherName;
    protected Calendar editionDate;
    protected String lang;
    protected String country;

    protected int id;
    protected int readerId;

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

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Calendar getEditionDate() {
        return editionDate;
    }

    public String getName() {
        return name;
    }

    public String[] getAuthorName() {
        return authorName;
    }

    @Override
    public int compareTo(Object o) {

        Edition ed = (Edition) o;

        if (name.compareTo(ed.getName()) != 0) {

            return name.compareTo(ed.getName());

        } else {

            if (authorName.toString().compareTo(ed.getAuthorName().toString()) != 0) {
                return authorName.toString().compareTo(ed.getAuthorName().toString());
            } else {
                return editionDate.compareTo(ed.getEditionDate());
            }
        }
    }

    public class EditionCompar implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {

            Edition e1 = (Edition) o1;
            Edition e2 = (Edition) o2;

            return e1.compareTo(e2);
        }
    }

}
