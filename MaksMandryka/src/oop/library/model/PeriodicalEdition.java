package oop.library.model;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class PeriodicalEdition extends PrintedEdition{

    protected String period;
    protected String subject;


    //В класс ПереодическоеИздание добавить final метод, который будет возвращать String с базовой информацией
    // об переодическом издании (info())
    public final String info() {

        StringBuilder sb = new StringBuilder();

        sb.append(name).append(". ").append(authorName.toString()).append(". ")
                .append(publisherName).append(". ").append(editionDate).append(". ").append(lang)
                .append(country).append(". ").append(period).append(". ").append(subject);
        return sb.toString();
    }

}
