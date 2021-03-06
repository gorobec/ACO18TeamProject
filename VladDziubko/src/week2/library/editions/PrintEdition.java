package week2.library.editions;

public class PrintEdition {
    private String name;
    private String author;
    private String genre;
    private int year;

    public PrintEdition() {
    }

    public PrintEdition(String name, String author, String genre, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        PrintEdition printEdition = (PrintEdition) o;
        return name.equals(printEdition.name) && author.equals(printEdition.author)
                && genre.equals(printEdition.genre) && year == printEdition.year;
    }

    // В класс ПереодическоеИздание добавить final метод,
    // который будет возвращать String с базовой информацией об переодическом издании (info()).
    public final String toString() {
        return String.format("\"%s\" , author -> %s, genre -> %s, year -> %d\n", name, author, genre, year);
    }


}
