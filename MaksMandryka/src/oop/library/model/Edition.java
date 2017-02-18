package oop.library.model;

import java.util.Arrays;
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

    public Edition(String name, String[] authorName, String publisherName, Calendar editionDate, String lang, String country) {
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.editionDate = editionDate;
        this.lang = lang;
        this.country = country;
    }

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

            if (Arrays.toString(authorName).compareTo(Arrays.toString(ed.getAuthorName())) != 0) {
                return Arrays.toString(authorName).compareTo(Arrays.toString(ed.getAuthorName()));
            } else {
                return editionDate.compareTo(ed.getEditionDate());
            }
        }
    }

    public static class EditionCompar implements Comparator<Edition> {
        @Override
        public int compare(Edition e1, Edition e2) {

            return e1.compareTo(e2);
        }
    }

}
