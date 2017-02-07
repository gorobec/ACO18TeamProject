package oop.library.model;

import java.util.Calendar;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Book extends PrintedEdition {

    protected Genres[] genres;

    public Book(String name, String[] authorName, String publisherName, Calendar editionDate, String lang, String country, String format, int pages, int circulation, Genres[] genres) {
        super(name, authorName, publisherName, editionDate, lang, country, format, pages, circulation);
        this.genres = genres;
    }

    public enum Genres {
        SCIENCE_FICTION, SATIRE, DRAMA, ACTION_AND_ADVENTURE, ROMANCE, MYSTERY, HORROR, SELF_HELP, HEALTH, GUIDE, TRAVEL, CHILDREN, RELIGION, SPIRITUALITY_AND_NEW_AGE, SCIENCE, HISTORY, MATH, POETRY, ENCYCLOPEDIAS, DICTIONARIES, COMICS, ART, COOKBOOKS, DIARIES, JOURNALS, PRAYER_BOOKS, SERIES, BIOGRAPHIES, AUTOBIOGRAPHIES, FANTASY
    }

}
