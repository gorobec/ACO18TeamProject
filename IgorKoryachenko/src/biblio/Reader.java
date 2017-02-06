package biblio;

import week1.homeWork.implementAL.ArrList;

/**
 * Created by Мастер on 29.01.2017.
 */
public class Reader {
    private String surname;
    private ArrList editions;
    private boolean isInBlacklist;

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

    public String getSurname() {
        return surname;
    }

    public ArrList getEditions() {
        return editions;
    }

    public boolean isInBlacklist() {
        return isInBlacklist;
    }

    public void setInBlacklist(boolean inBlacklist) {
        isInBlacklist = inBlacklist;
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
