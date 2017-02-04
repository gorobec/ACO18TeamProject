package ACO.week2.homework.library.model.printed_editions;

/**
 * Created by v21k on 31.01.17.
 */
public class PrintedEdition {
    private Genre genre;
    private String name;
    private String author;
    private int year;

    public PrintedEdition(Genre genre, String name, String author, int year) {
        this.genre = genre;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("Name : %s, genre : %s, author : %s, year : %d",
                name, genre, author, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrintedEdition that = (PrintedEdition) o;

        if (year != that.year) return false;
        if (genre != that.genre) return false;
        if (!name.equals(that.name)) return false;
        return author.equals(that.author);
    }

    @Override
    public int hashCode() {
        int result = genre.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + year;
        return result;
    }
}
