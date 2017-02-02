package library;

import library.comparators.*;
import library.controller.Library;
import library.model.PrintedEditions;
import library.model.Book;
import library.model.Reader;

public class Run {
    public static void main(String[] args) {

        Library library = new Library();

        Book effectiveJava = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);
        Book thinkingInJava = new Book("Thinking in Java", "Bruce Eckel",
                2006, 20, 1079);
        Book headFirstJava = new Book("Head First Java", "Kathy Sierra, Bert Bates",
                2003, 15, 650);
        Book goneWithTheWind = new Book("Gone With The Wind", "Margaret Mitchell",
                1946, 3, 1061);


        library.addPrintedEdition(effectiveJava);
        library.addPrintedEdition(thinkingInJava);
        library.addPrintedEdition(headFirstJava);


        Reader reader1 = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        Reader reader2 = new Reader("Bruce", "Willis", 50, "Kiev, L.Tolstogo 10");
        Reader reader3 = new Reader("Dolf", "Lungren", 52, "Kiev, Baseyna 13");
        Reader reader4 = new Reader("Koby", "Briant", 35, "Kiev, Darvyna 10");

        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);


        // 1) посмотреть список читателей
        System.out.println("Добавлено 3 читателя (отсортировано по имени):");
        library.showAllRegisteredReaders(new ReaderNameComparator());
        System.out.println();

        // 2) посмотреть список доступных конкретных печатных изданий
        System.out.println("Добавлено 3 печатных издания (отсортировано по году издания):");
        library.showPrintedEditions(library.getPrintedEditionsBase(), new PrintedEditionComparatorByPublishYear());
        System.out.println();
        System.out.println("Вывод предыдушего другим методом (отсортировано по имени автора) :");
        library.showPrintedEditionsAvailable(new PrintedEditionComparatorByAuthor());
        System.out.println();

        // 3) добавить печатное издание в библиотеку
        System.out.println("Добавлено 4-ое печатное издание :");
        System.out.println(library.addPrintedEdition(goneWithTheWind));
        System.out.println();

        // 4) добавить читателя в список читателей
        System.out.println("Добавлено 4-ого читателя :");
        System.out.println(library.addReader(reader4));
        System.out.println();

        // 6) посмотреть список печатных изданий, которые находятся у читателей
        System.out.println("Смотрим список изданий, которые находятся у читателей (отсортировано по названию книги):");
        library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName());
        System.out.println();

        // 5) выдать печатное издание читателю (если книга есть в наличии).
        // Читателю запрещается брать больше 3-х печатных изданий.
        System.out.println("Выдаем книги 4-му,  1-му читателю и 2-му читателю:");
        System.out.println(library.loanPrintedEdition(reader4, goneWithTheWind));
        System.out.println(library.loanPrintedEdition(reader1, effectiveJava));
        System.out.println(library.loanPrintedEdition(reader2, thinkingInJava));
        System.out.println();

        // 6) посмотреть список печатных изданий, которые находятся у читателей
        System.out.println("Смотрим список изданий, которые находятся у читателей (отсортировано по названию книги):");
        library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName());
        System.out.println();

        // 7) посмотреть список печатных изданий, которые находятся у конкретного читателя
        System.out.println("Смотрим список печатных изданий, которые находятся у 4-го читателя :");
        System.out.println(library.showPrintedEditionsAtOneReader(reader4));
        System.out.println();

        // 8) добавить читателя в черный список (ему нельзя выдавать печатные издания)
        System.out.println("Добавляем 2-го читателя  в черный список :");
        System.out.println(library.addToBlackList(reader2));
        System.out.println("Пытаемся выдать 2-му читателю  книгу: ");
        System.out.println(library.loanPrintedEdition(reader2, thinkingInJava));
        System.out.println("Смотрим список печатных изданий, которые находятся у 2-го читателя :");
        System.out.println(library.showPrintedEditionsAtOneReader(reader2));
        System.out.println();

        // 9) посмотреть печатные издания конкретного автора
        // 10) посмотреть печатные издания конкретного автора
        System.out.println("Смотрим список печатных изданий конкреного автора :");
        library.showPrintedEditionsOfAuthor(library.getPrintedEditionsBase(), "Joshua Bloch"
                , new PrintedEditionComparatorByName());
        System.out.println();

        // 9) посмотреть печатные издания конкретного автора
        // 10) посмотреть печатные издания конкретного автора
        System.out.println("Смотрим список печатных изданий конкреного автора :");
        library.showPrintedEditionsOfAuthor(library.getPrintedEditionsBase(), "Bruce Eckel"
                , new PrintedEditionComparatorByName());
        System.out.println();

        // 11) посмотреть печатные издания конкретного года
        System.out.println("Смотрим список печатных изданий конкреного года :");
        library.showPrintedEditionsOfYear(library.getPrintedEditionsBase(), 2006
                , new PrintedEditionComparatorByName());
        System.out.println();

        // 12) найти печатное издание по названию (ключевым словам)
        System.out.println("Ищем печатное издание по названию (ключевым словам)");
        library.findPrintedEditionByKeyWord(library.getPrintedEditionsBase(), "Java"
                , new PrintedEditionComparatorByPublishYear());

        // 12) найти печатное издание по названию (ключевым словам)
        System.out.println("Ищем печатное издание по названию (ключевым словам,игнорируя регистр)");
        library.findPrintedEditionByKeyWord(library.getPrintedEditionsBase(), "WIND"
                , new PrintedEditionComparatorByPublishYear());

    }
}
