package biblio;

import week1.homeWork.implementAL.ArrList;

public class Library {
    private ArrList<Reader> readers = new ArrList<>();
    private ArrList<Edition> editions = new ArrList<>();


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
    public String availableEdition(String name) {
        String str = "";

        for (int i = 0; i < editions.size(); i++) {
            Edition temp = (Edition) editions.get(i);

            if ( temp.getName().equals(name) && temp.getKolvo() > 0 ){
                str += temp + ("\n");
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
    public boolean issueEdition(String surname, String name) {
        Reader reader = findReader(surname);
        Edition edition = findEdition(name);
        if (editions.contains(edition)) {
            assert reader != null;
            if (reader.getEditions().size() >= 3 || reader.isInBlacklist()) {
                System.out.println("Достаточно. Читай что взял");
                return false;
            } else {
                reader.getEditions().add(edition);
                edition.setKolvo(edition.getKolvo() - 1);
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

            for (int j = 0; j < reader.getEditions().size(); j++) {
                Edition temp = (Edition) reader.getEditions().get(j);
                str.append(temp).append("\n");
            }
        }
        return str;
    }

    //8) добавить читателя в черный список (ему нельзя выдавать печатные издания)
    public boolean addReaderToBlackList(String surname){
        Reader reader = findReader(surname);
        if (reader == null){
            System.out.println("Такого читателя нет");
            return false;
        }
        reader.setInBlacklist(true);
        return true;
    }

    //9) посмотреть печатные издания конкретного автора
    public String showEditionsByAuthor(String author){
        String str = "";
        for (int i = 0; i < editions.size(); i++) {
            Edition temp = (Edition) editions.get(i);
            if (temp.getClass().getName().equals("biblio.Book")){
                Book book = (Book) editions.get(i);
                if (book.getAuthor().equals(author)){
                    str += temp + ("\n");
                }
            }
        }
        return str;
    }

    //11) посмотреть печатные издания конкретного года
    public String showEditionsByYear(int year){
        String str = "";
        for (int i = 0; i < editions.size(); i++) {
            Edition temp = (Edition) editions.get(i);
            if (temp.getClass().getName().equals("biblio.Journal")){
                Journal journal = (Journal) editions.get(i);
                if (journal.getYear() == year){
                    str += temp+ ("\n");
                }
            }
        }
        return str;
    }


    //для отладки
//    void showBlackList(){
//        for (int i = 0; i < blackList.size(); i++) {
//            System.out.println(blackList.get(i));
//        }
//    }

    //для отладки
    public void showEdition() {
        for (int i = 0; i < editions.size(); i++) {
            System.out.println(editions.get(i));
        }
    }

    private Reader findReader(Reader reader){
        for (int i = 0; i < readers.size(); i++) {
            Reader reader1 = (Reader) readers.get(i);
            if(reader1.equals(reader))
                return (Reader) readers.get(i);
        }
        //System.out.println("Такого читателя не найдено");
        return null;
    }

    private Edition findEdition(Edition edition){
        for (int i = 0; i < editions.size(); i++) {
            Edition edition1 = (Edition) editions.get(i);
            if(edition1.equals(edition))
                return (Edition) editions.get(i);
        }
       // System.out.println("Такого издания не найдено");
        return null;
    }



}
