package biblio;

import week1.homeWork.implementAL.ArrList;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Reader {
    String surname;
    ArrList editions;

    public Reader() {
    }

    public Reader(String surname, ArrList editions) {
        this.surname = surname;
        this.editions = editions;
    }

    public StringBuilder showReader(){
        StringBuilder str = new StringBuilder("Surname - " + surname + "\n");
        for (int i = 0; i < editions.size(); i++) {
            str.append(editions.get(i));
        }
        return str;
    }
}
