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


        Book book1 = new Book("Voina i mir", 10, "Tolstoy");
        Book book2 = new Book("Idiot", 52,  "Dostoevskiy");
        Book book3 = new Book("Palata №6", 32, "Chehov");
        Book book4 = new Book("Ovod", 10, "Voinich");
        Book book5 = new Book("Van`ka", 5, "Chehov");
        Book book6 = new Book("Chaika", 12, "Chehov");
        Book book7 = new Book("Kashtanka", 3, "Chehov");

        Journal journal1 = new Journal("Burda", 3, 12, 2012);
        Journal journal2 = new Journal("Playboby", 5, 5, 2002);
        Journal journal3 = new Journal("Elle", 11, 8, 2013);
        Journal journal4 = new Journal("Doyarka", 6, 3, 1960);
        Journal journal5 = new Journal("Doyarka", 2, 2, 1962);
        Journal journal6 = new Journal("Playboby", 12, 5, 2012);

        /*books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        publishers1.add(book1);
        publishers1.add(journal1);


        *//*for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }*//*

        System.out.println(reader1.showReader());*/

        Library library = new Library();
        library.addEditions(journal1);
        library.addEditions(journal2);
        library.addEditions(journal3);
        library.addEditions(journal4);
        library.addEditions(journal5);
        library.addEditions(journal6);
        library.addEditions(book4);
        library.addEditions(book2);
        library.addEditions(book1);
        library.addEditions(book5);
        library.addEditions(book6);
        library.addEditions(book7);
        library.addEditions(book3);
        //library.showEdition();
        //System.out.println(library.availableEdition("Doyarka"));

        Reader reader1 = new Reader("Ivanov", new ArrList());
        library.addReader(reader1);
        library.issueEdition(reader1, book3);
        library.issueEdition(reader1, book2);
        library.issueEdition(reader1, journal2);
        library.issueEdition(reader1, journal3);
        System.out.println(reader1.showReader());

        //System.out.println(reader1.showReader());
        System.out.println();
        System.out.println(library.showEditionsByYear(2012));

        library.showBlackList();


    }


}
