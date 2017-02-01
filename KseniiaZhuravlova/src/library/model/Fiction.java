package library.model;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class Fiction extends Book {
    private Genre genre;
    public Fiction(String name, String author, int year, int number, Genre genre) {

        super(name, author, year, number);
        this.genre = genre;
    }

    public Genre getGenre() {return genre; }
}
