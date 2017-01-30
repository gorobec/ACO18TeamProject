package biblio;

import week1.homeWork.implementAL.ArrList;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Library {
    private ArrList books;
    private ArrList editions;
    private ArrList readers;

    /*ArrList books = new ArrList();
    ArrList journals = new ArrList();*/

    public StringBuilder showReaders(){
        Reader reader = new Reader();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < readers.size(); i++) {
            str.append(reader.showReader());
        }
        return str;
    }

    public boolean addReader(Reader reader){
        readers.add(reader);
        return true;
    }public boolean addEditions(Edition edition){
        editions.add(edition);
        return true;
    }

    public boolean issueEdition(Reader reader, Edition edition) {
        if (editions.contains(edition)) {
            if (reader.editions.size() >= 3) {
                System.out.println("Достаточно. Читай что взял");
                return false;
            } else {
                reader.editions.add(edition);
                return true;
            }
        }
        return false;
    }


}
