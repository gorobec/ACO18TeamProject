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

    public Reader(String surname) {
        this.surname = surname;
    }

    public Reader(String surname, ArrList editions) {
        this.surname = surname;
        this.editions = editions;
    }

    public StringBuilder showReader(){
        StringBuilder str = new StringBuilder("Surname - " + surname + "\n");
        for (int i = 0; i < editions.size(); i++) {
            str.append(editions.get(i)).append("\n");
        }
        return str;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Reader reader = (Reader) object;

        if (surname != null ? !surname.equals(reader.surname) : reader.surname != null) return false;
        return editions != null ? editions.equals(reader.editions) : reader.editions == null;
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (editions != null ? editions.hashCode() : 0);
        return result;
    }
}
