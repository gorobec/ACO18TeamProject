package oop.library.model;

import java.util.Calendar;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Journal extends PeriodicalEdition{

    public Journal(String name, String[] authorName, String publisherName, Calendar editionDate, String lang, String country, String format, int pages, int circulation, String period, String subject) {
        super(name, authorName, publisherName, editionDate, lang, country, format, pages, circulation, period, subject);
    }
}
