package week2.library.readers;

public class Reader implements Comparable {
    private String name;
    private String surname;
    private int age;

    private int actualBookCount;

    public Reader() {
    }

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Reader(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getActualBookCount() {
        return actualBookCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Reader reader = (Reader) o;
        return name == reader.name && surname == reader.surname && age == reader.age
                && actualBookCount == reader.actualBookCount;
    }

    @Override
    public int compareTo(Object o) {
        Reader reader = (Reader) o;
        int res = name.compareTo(reader.name);
        if(res != 0){
            return res;
        }
        res = surname.compareTo(reader.surname);
        if(res != 0){
            return res;
        }
        return 0;
    }

    // 5) выдать печатное издание читателю (если книга есть в наличии).
    // Читателю запрещается брать больше 3-х печатных изданий.
    // 8) добавить читателя в черный список (ему нельзя выдавать печатные издания)
    // take a book
    public StringBuilder takeABook() {
        if (actualBookCount == 3) {
            return messageDenied();
        } else {
            actualBookCount++;
        }
        return messageGranted();
    }

    //return a book
    public StringBuilder returnABook() {
        if (actualBookCount == 0) {
            return noBooks();
        } else {
            actualBookCount--;
        }
        return bookReturned();
    }

    private StringBuilder noBooks() {
        return new StringBuilder("You have no books.");
    }

    private StringBuilder bookReturned() {
        return new StringBuilder("Book returned.");
    }

    private StringBuilder messageDenied() {
        return new StringBuilder("You have 3 books already!" +
                "Please return them and after you can take other books.");
    }

    private StringBuilder messageGranted() {
        return new StringBuilder("Enjoy reading!");
    }


}
