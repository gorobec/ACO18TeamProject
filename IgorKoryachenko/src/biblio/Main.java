package biblio;

import week1.homeWork.implementAL.ArrList;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Main {
    public static void main(String[] args) {

        ArrList books = new ArrList();
        ArrList journals = new ArrList();
        ArrList publishers1 = new ArrList();


        Book book1 = new Book("Voina i mir",  "Tolstoy", 10);
        Book book2 = new Book("Idiot",  "Dostoevskiy", 15);
        Book book3 = new Book("Palata №6",  "Chehov", 5);
        Book book4 = new Book("Ovod",  "Voinich", 12);

        Journal journal1 = new Journal("Burda", 3, 2013, 20);
        Journal journal2 = new Journal("Playboby", 5, 2015, 16);
        Journal journal3 = new Journal("Elle", 11, 2011, 14);
        Journal journal4 = new Journal("Doyarka", 6, 1960, 2);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        publishers1.add(book1);
        publishers1.add(journal1);

        Reader reader1 = new Reader("Ivanov", publishers1);

        /*for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }*/

        System.out.println(reader1.showReader());

        Library library = new Library();
        library.addEditions(journal2);
        library.addEditions(journal4);
        library.addEditions(book4);
        library.addEditions(book2);
        library.showEdition();


        System.out.println(library.editions.get(0).getClass().getName());


    }


}
