package library.controller;

import library.model.PrintedEditions;
import library.model.Reader;
import library.utils.ArrayListMy;

import java.util.Comparator;

public class Library {

    private ArrayListMy printedEditionsBase;

    private ArrayListMy registeredReaders;


    public ArrayListMy getPrintedEditionsBase() {
        return printedEditionsBase;
    }

    public Library() {
        printedEditionsBase = new ArrayListMy();
        registeredReaders = new ArrayListMy();
    }

    public boolean isRegistered(Reader someReader) {
        boolean isRegistered = false;
        for (int i = 0; i < registeredReaders.size(); i++) {
            if (registeredReaders.get(i).equals(someReader)) {
                isRegistered = true;
                break;
            }
        }
        return isRegistered;
    }

    public boolean isAvailablePrintEds(PrintedEditions edition) {
        boolean isAvailablePrintEds = false;
        if (edition != null) {
            for (int i = 0; i < printedEditionsBase.size(); i++) {
                PrintedEditions editionTemp = (PrintedEditions) printedEditionsBase.get(i);
                if (editionTemp.getNumberOfCopiesAvailable() > 0) {
                    isAvailablePrintEds = true;
                    break;
                }
            }
        }
        return isAvailablePrintEds;
    }

    public boolean sortPrintedEditionByComparator(ArrayListMy list, Comparator comparator) {
        boolean wasSorted = false;
        int changesCount = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j) != null) {
                    if (comparator.compare(list.get(j), list.get(j - 1)) < 0) {
                        PrintedEditions edition1 = (PrintedEditions) list.get(j);
                        PrintedEditions edition2 = (PrintedEditions) list.get(j - 1);
                        PrintedEditions editionTemp = edition1;
                        list.set(j, edition2);
                        list.set(j - 1, editionTemp);
                        changesCount++;
                    }
                }
            }
        }
        wasSorted = (changesCount != 0);
        return wasSorted;
    }

    public boolean sortReadersByComparator(ArrayListMy list, Comparator comparator) {
        boolean wasSorted = false;
        int changesCount = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j) != null) {
                    if (comparator.compare(list.get(j), list.get(j - 1)) < 0) {
                        Reader reader1 = (Reader) list.get(j);
                        Reader reader2 = (Reader) list.get(j - 1);
                        Reader readerTemp = reader1;
                        list.set(j, reader2);
                        list.set(j - 1, readerTemp);
                        changesCount++;
                    }
                }
            }
        }
        wasSorted = (changesCount != 0);
        return wasSorted;
    }

    // 1)посмотреть список читателей
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public void showAllRegisteredReaders(Comparator comparator) {
        sortReadersByComparator(registeredReaders, comparator);
        for (int i = 0; i < registeredReaders.size(); i++) {
            if (registeredReaders.get(i) != null) {
                Reader reader = (Reader) registeredReaders.get(i);
                System.out.println(reader.showReader());
            }
        }
    }

    // 2)посмотреть список доступных конкретных печатных изданий(универсальный метод )
    // 6)посмотреть список печатных изданий,которые находятся у читателей
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public void showPrintedEditions(ArrayListMy list, Comparator comparator) {
        sortPrintedEditionByComparator(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) list.get(i);
                System.out.println(String.format("Издание - %s, количество в библиотеке - %d, у читателей - %d",
                        edition.showEdition(), edition.getNumberOfCopiesAvailable(), edition.getNumberOfCopiesAtReader()));
            }
        }
    }

    // 2)посмотреть список доступных конкретных печатных изданий
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public void showPrintedEditionsAvailable(Comparator comparator) {
        sortPrintedEditionByComparator(printedEditionsBase, comparator);
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (edition.getNumberOfCopiesAvailable() > 0) {
                    System.out.println(String.format("Издание - %s, количество доступно - %d",
                            edition.showEdition(), edition.getNumberOfCopiesAvailable()));
                }
            }
        }
    }

    // 3)добавить печатное издание в библиотеку
    public boolean addPrintedEdition(PrintedEditions edition) {
        boolean wasAdded = false;
        if (edition != null) {
            printedEditionsBase.add(edition);
            wasAdded = true;
        }
        return wasAdded;
    }

    // 4)добавить читателя в список читателей
    public boolean addReader(Reader reader) {
        boolean wasAdded = false;
        if ( !isRegistered(reader) && reader != null) {
            registeredReaders.add(reader);
            wasAdded = true;
        }
        return wasAdded;
    }

    // 5)выдать печатное издание читателю(если книга есть в наличии).
    // Читателю запрещается брать больше 3-х печатных изданий.
    public boolean loanPrintedEdition(Reader reader, PrintedEditions edition) {
        boolean canLoan = false;
        if (edition != null && reader.getCounterOfPrintEds() < 3 &&
                !reader.isInBlackList() && isAvailablePrintEds(edition )&&
                !reader.isEditionInReaderList(edition)) {
            reader.addPrintedEditionToList(edition);
            edition.setNumberOfCopiesAvailable(edition.getNumberOfCopiesAvailable() - 1);
            edition.setNumberOfCopiesAtReader(edition.getNumberOfCopiesAtReader() + 1);
            canLoan = true;
        }
        return canLoan;
    }

    // 6)посмотреть список печатных изданий,которые находятся у читателей
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public void showPrintedEditionsAtReaders(Comparator comparator) {
        sortPrintedEditionByComparator(printedEditionsBase, comparator);
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (edition.getNumberOfCopiesAtReader() > 0) {
                    System.out.println(String.format("Издание - %s, количество у читатилей - %d",
                            edition.showEdition(), edition.getNumberOfCopiesAtReader()));
                }
            }
        }
    }

    // 7)посмотреть список печатных изданий,которые находятся у конкретного читателя
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public String showPrintedEditionsAtOneReader(Reader reader) {
        String result = "";
        if (reader.getReaderEditions().size() > 0) {
            for (int i = 0; i < reader.getReaderEditions().size(); i++) {
                PrintedEditions edition = (PrintedEditions) reader.getReaderEditions().get(i);
                result = edition.showEdition() + "\n";
            }
        }
        return result;
    }

    // 8)добавить читателя в черный список(ему нельзя выдавать печатные издания)
    public boolean addToBlackList(Reader reader) {
        boolean wasAdded = false;
        if (reader != null && !reader.isInBlackList()) {
            reader.setInBlackList(true);
            wasAdded = true;
        }
        return wasAdded;
    }

    // 9)посмотреть печатные издания конкретного автора
    // 10)посмотреть печатные издания конкретного автора
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public void showPrintedEditionsOfAuthor(ArrayListMy list, String author, Comparator comparator) {
        sortPrintedEditionByComparator(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) list.get(i);
                if (edition.getAuthor().compareToIgnoreCase(author) == 0) {
                    System.out.println(edition.showEdition());
                }
            }
        }
    }

    // 11)посмотреть печатные издания конкретного года
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public void showPrintedEditionsOfYear(ArrayListMy list, int year, Comparator comparator) {
        sortPrintedEditionByComparator(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) list.get(i);
                if (edition.getPublicationYear() == year) {
                    System.out.println(edition.showEdition());
                }
            }
        }
    }

    // 12)найти печатное издание по названию(ключевым словам)
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде

    public PrintedEditions findPrintedEditionByKeyWord(ArrayListMy list, String keyWord, Comparator comparator) {
        sortPrintedEditionByComparator(list, comparator);
        PrintedEditions foundEdition = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) list.get(i);
                if (findStringByKeyWord(edition.getName(), keyWord) == true) {
                    System.out.println(edition.showEdition());
                    continue;
                }
            }
        }
        return foundEdition;
    }

    public boolean findStringByKeyWord(String string, String keyWord) {
        boolean wasFounded = false;
        if (string != null && keyWord != null && string.length() >= keyWord.length()) {
            for (int i = 0; i < (string.length() - keyWord.length() + 1); i++) {
                if (string.substring(i, i + keyWord.length()).compareToIgnoreCase(keyWord) == 0) {
                    wasFounded = true;
                    break;
                }
            }
        }
        return wasFounded;
    }

}
