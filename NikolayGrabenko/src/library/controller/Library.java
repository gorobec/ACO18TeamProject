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

    public ArrayListMy getRegisteredReaders() {
        return registeredReaders;
    }

    public Library() {
        printedEditionsBase = new ArrayListMy();
        registeredReaders = new ArrayListMy();
    }

    public boolean isRegistered(Reader someReader) {
        boolean isRegistered = false;
        for (int i = 0; i < registeredReaders.size(); i++) {
            Reader tempReader = (Reader) registeredReaders.get(i);
            if (tempReader.equals(someReader)) {
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

    public boolean sortPrintedEditionByComparator(Comparator comparator) {
        boolean wasSorted = false;
        int changesCount = 0;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            for (int j = printedEditionsBase.size() - 1; j > i; j--) {
                if (printedEditionsBase.get(j) != null) {
                    if (comparator.compare(printedEditionsBase.get(j), printedEditionsBase.get(j - 1)) < 0) {
                        PrintedEditions edition1 = (PrintedEditions) printedEditionsBase.get(j);
                        PrintedEditions edition2 = (PrintedEditions) printedEditionsBase.get(j - 1);
                        PrintedEditions editionTemp = edition1;
                        printedEditionsBase.set(j, edition2);
                        printedEditionsBase.set(j - 1, editionTemp);
                        changesCount++;
                    }
                }
            }
        }
        wasSorted = (changesCount != 0);
        return wasSorted;
    }

    public boolean sortReadersByComparator(Comparator comparator) {
        boolean wasSorted = false;
        int changesCount = 0;
        for (int i = 0; i < registeredReaders.size(); i++) {
            for (int j = registeredReaders.size() - 1; j > i; j--) {
                if (registeredReaders.get(j) != null) {
                    if (comparator.compare(registeredReaders.get(j), registeredReaders.get(j - 1)) < 0) {
                        Reader reader1 = (Reader) registeredReaders.get(j);
                        Reader reader2 = (Reader) registeredReaders.get(j - 1);
                        Reader readerTemp = reader1;
                        registeredReaders.set(j, reader2);
                        registeredReaders.set(j - 1, readerTemp);
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
    public boolean showAllRegisteredReaders(Comparator comparator) {
        sortReadersByComparator(comparator);
        boolean canShow = false;
        int readerCounter = 0;
        for (int i = 0; i < registeredReaders.size(); i++) {
            if (registeredReaders.get(i) != null) {
                Reader reader = (Reader) registeredReaders.get(i);
                readerCounter++;
                canShow = true;
                System.out.println(reader.showReader());
            }
        }
        return canShow = readerCounter > 0;
    }

    // 2)посмотреть список доступных конкретных печатных изданий(универсальный метод )
    // 6)посмотреть список печатных изданий,которые находятся у читателей
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public boolean showPrintedEditions(Comparator comparator) {
        sortPrintedEditionByComparator(comparator);
        boolean canShow = false;
        int editionCounter = 0;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                editionCounter++;
                canShow = true;
                System.out.println(String.format("Издание - %s, количество в библиотеке - %d, у читателей - %d",
                        edition.showEdition(), edition.getNumberOfCopiesAvailable(), edition.getNumberOfCopiesAtReader()));
            }
        }
        return canShow = editionCounter > 0;
    }

    // 2)посмотреть список доступных конкретных печатных изданий
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public boolean showPrintedEditionsAvailable(Comparator comparator) {
        sortPrintedEditionByComparator(comparator);
        boolean canShow = false;
        int editionCounter = 0;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (edition.getNumberOfCopiesAvailable() > 0) {
                    canShow = true;
                    editionCounter++;
                    System.out.println(String.format("Издание - %s, количество доступно - %d",
                            edition.showEdition(), edition.getNumberOfCopiesAvailable()));
                }
            }
        }
        return canShow = editionCounter > 0;
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
        if (!isRegistered(reader) && reader != null) {
            registeredReaders.add(reader);
            wasAdded = true;
        }
        return wasAdded;
    }

    // 5)выдать печатное издание читателю(если книга есть в наличии).
    // Читателю запрещается брать больше 3-х печатных изданий.
    public boolean loanPrintedEdition(String readerName, String readerSurName, int age, PrintedEditions edition) {
        Reader reader = findReaderByNameAndSurname(readerName, readerSurName, age);
        PrintedEditions printedEdition = findEdition(edition);
        if (printedEdition != null && reader != null && reader.getCounterOfPrintEds() < 3 &&
                reader.isNotInBlackList() && isAvailablePrintEds(printedEdition)) {
            reader.addPrintedEditionToList(printedEdition);
            printedEdition.setNumberOfCopiesAvailable(printedEdition.getNumberOfCopiesAvailable() - 1);
            printedEdition.setNumberOfCopiesAtReader(printedEdition.getNumberOfCopiesAtReader() + 1);
            return true;
        }
        return false;
    }

    private PrintedEditions findEdition(PrintedEditions edition) {
        PrintedEditions printedEdition = null;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (edition.equals(printedEditionsBase.get(i))) {
                printedEdition = (PrintedEditions) printedEditionsBase.get(i);
            }
        }
        return printedEdition;
    }

    public Reader findReaderByNameAndSurname(String readerName, String readerSurName, int age) {
        Reader reader = null;
        for (int i = 0; i < registeredReaders.size(); i++) {
            if (registeredReaders.get(i) != null) {
                reader = (Reader) registeredReaders.get(i);
                if (reader.getName().equals(readerName) &&
                        reader.getSurName().equals(readerSurName) &&
                        reader.getAge() == age)
                    break;
            }
        }
        return reader;
    }

    // 6)посмотреть список печатных изданий,которые находятся у читателей
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public boolean showPrintedEditionsAtReaders(Comparator comparator) {
        sortPrintedEditionByComparator(comparator);
        int editionCounter = 0;
        boolean canShow = false;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (edition.getNumberOfCopiesAtReader() > 0) {
                    editionCounter++;
                    canShow = true;
                    System.out.println(String.format("Издание - %s, количество у читатилей - %d",
                            edition.showEdition(), edition.getNumberOfCopiesAtReader()));
                }
            }
        }
        return canShow = editionCounter > 0;
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
        if (reader != null && reader.isNotInBlackList()) {
            reader.setNotInBlackList(false);
            wasAdded = true;
        }
        return wasAdded;
    }

    // 9)посмотреть печатные издания конкретного автора
    // 10)посмотреть печатные издания конкретного автора
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public boolean showPrintedEditionsOfAuthor(String author, Comparator comparator) {
        sortPrintedEditionByComparator(comparator);
        int editionsCounter = 0;
        boolean hasEdition = false;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (edition.getAuthor().compareToIgnoreCase(author) == 0) {
                    editionsCounter++;
                    System.out.println(edition.showEdition());
                }
            }
        }
        return hasEdition = editionsCounter > 0;
    }

    // 11)посмотреть печатные издания конкретного года
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде
    public boolean showPrintedEditionsOfYear(int year, Comparator comparator) {
        sortPrintedEditionByComparator(comparator);
        int editionsCounter = 0;
        boolean hasEdition = false;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (edition.getPublicationYear() == year) {
                    editionsCounter++;
                    System.out.println(edition.showEdition());
                }
            }
        }
        return hasEdition = editionsCounter > 0;
    }

    // 12)найти печатное издание по названию(ключевым словам)
    // *пункты 1,2,6,7,9,10,11,12выводить в отсортированом виде

    public PrintedEditions findPrintedEditionByKeyWord(String keyWord, Comparator comparator) {
        sortPrintedEditionByComparator(comparator);
        PrintedEditions foundEdition = null;
        for (int i = 0; i < printedEditionsBase.size(); i++) {
            if (printedEditionsBase.get(i) != null) {
                PrintedEditions edition = (PrintedEditions) printedEditionsBase.get(i);
                if (findStringByKeyWord(edition.getName(), keyWord)) {
                    foundEdition = edition;
                    System.out.println(foundEdition.showEdition());
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
