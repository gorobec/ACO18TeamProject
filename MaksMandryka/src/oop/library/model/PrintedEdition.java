package oop.library.model;

import java.util.Calendar;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class PrintedEdition extends Edition{

    protected String format;
    protected int pages;
    protected int circulation;

    public PrintedEdition(String name, String[] authorName, String publisherName, Calendar editionDate, String lang, String country, String format, int pages, int circulation) {
        super(name, authorName, publisherName, editionDate, lang, country);
        this.format = format;
        this.pages = pages;
        this.circulation = circulation;
    }
}
