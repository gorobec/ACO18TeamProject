package oop.library.model;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class PeriodicalEdition extends PrintedEdition{

    protected String period;
    protected String subject;


    public PeriodicalEdition(String name, String[] authorName, String publisherName, Calendar editionDate, String lang, String country, String format, int pages, int circulation, String period, String subject) {
        super(name, authorName, publisherName, editionDate, lang, country, format, pages, circulation);
        this.period = period;
        this.subject = subject;
    }

    //В класс ПереодическоеИздание добавить final метод, который будет возвращать String с базовой информацией
    // об переодическом издании (info())
    public final String info() {

        StringBuilder sb = new StringBuilder();

        sb.append(name).append(". ").append(Arrays.toString(authorName)).append(". ")
                .append(publisherName).append(". ").append(editionDate).append(". ").append(lang)
                .append(country).append(". ").append(period).append(". ").append(subject);
        return sb.toString();
    }

}
