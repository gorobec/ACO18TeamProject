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


        Book book1 = new Book("Zori",  "Voina i mir", "Tolstoy");
        Book book2 = new Book("Pearson",  "Idiot", "Dostoevskiy");
        Book book3 = new Book("Wolters Kluwer",  "Palata №6", "Chehov");
        Book book4 = new Book("Wolters Kluwer",  "Voina i mir", "Tolstoi");

        Journal journal1 = new Journal("Burda", "Burda", 3, 2012);
        Journal journal2 = new Journal("Burda", "Playboy", 5, 2016);
        Journal journal3 = new Journal("France Editions", "Elle", 11, 2014);
        Journal journal4 = new Journal("Pravda", "Doyarka", 10, 1969);

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



    }


}
