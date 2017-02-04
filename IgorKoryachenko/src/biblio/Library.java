package biblio;

import week1.homeWork.implementAL.ArrList;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Library {
    ArrList readers = new ArrList();
    ArrList blackList = new ArrList();
    ArrList journals  = new ArrList();
    ArrList editions = new ArrList();
    //Utils utils = new Utils();

    //1) посмотреть список читателей
    //7) посмотреть список печатных изданий, которые находятся у конкретного читателя
    public StringBuilder showReaders() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = (Reader) readers.get(i);
            str.append(reader.showReader());
        }
        return str;
    }

    //2) посмотреть список доступных конкретных печатных изданий
    public StringBuilder availableEdition(String name) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < editions.size(); i++) {
            Edition temp = (Edition) editions.get(i);

            if ( temp.name.equals(name) && temp.kolvo > 0 ){
                str.append(temp).append("\n");
            }
        }
        return str;
    }

    //3) добавить печатное издание в библиотеку
    public boolean addEditions(Edition edition) {
        editions.add(edition);
        return true;
    }

    //4) добавить читателя в список читателей
    public boolean addReader(Reader reader) {
        readers.add(reader);
        return true;
    }

    //5) выдать печатное издание читателю (если книга есть в наличии).
    //Читателю запрещается брать больше 3-х печатных изданий.
    public boolean issueEdition(Reader reader, Edition edition) {
        if (editions.contains(edition)) {
            if (reader.editions.size() >= 3 || blackList.contains(reader)) {
                System.out.println("Достаточно. Читай что взял");
                return false;
            } else {
                reader.editions.add(edition);
                edition.kolvo--;
                return true;
            }
        }
        return false;
    }

    //6) посмотреть список печатных изданий, которые находятся у читателей
    public StringBuilder showEditionsOfReaders(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = (Reader) readers.get(i);

            for (int j = 0; j < reader.editions.size(); j++) {
                Edition temp = (Edition) reader.editions.get(j);
                str.append(temp).append("\n");
            }
        }
        return str;
    }

    //8) добавить читателя в черный список (ему нельзя выдавать печатные издания)
    public boolean addReaderToBlackList(Reader reader){
        if (!readers.contains(reader)){
            System.out.println("Такого читателя нет");
            return false;
        }
        blackList.add(reader);
        return true;
    }

    //9) посмотреть печатные издания конкретного автора
    public StringBuilder showEditionsByAuthor(String author){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < editions.size(); i++) {
            Edition temp = (Edition) editions.get(i);
            if (temp.getClass().getName().equals("biblio.Book")){
                Book book = (Book) editions.get(i);
                if (book.getAuthor().equals(author)){
                    str.append(temp).append("\n");
                }
            }
        }
        return str;
    }

    //11) посмотреть печатные издания конкретного года
    public StringBuilder showEditionsByYear(int year){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < editions.size(); i++) {
            Edition temp = (Edition) editions.get(i);
            if (temp.getClass().getName().equals("biblio.Journal")){
                Journal journal = (Journal) editions.get(i);
                if (journal.getYear() == year){
                    str.append(temp).append("\n");
                }
            }
        }
        return str;
    }


    //для отладки
    void showBlackList(){
        for (int i = 0; i < editions.size(); i++) {
            System.out.println(editions.get(i));
        }
    }

    //для отладки
    public void showEdition() {
        for (int i = 0; i < editions.size(); i++) {
            System.out.println(editions.get(i));
        }
    }



}
