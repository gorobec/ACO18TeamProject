package library.controller;

import data_structures.MyArrayList;
import library.controller.interfaces.AddItemAble;
import library.controller.interfaces.Showable;
import library.model.Author;
import library.model.PrintEdition;
import library.model.Reader;
import java.util.Comparator;
/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Library implements AddItemAble, Showable {
    MyArrayList readers;
    MyArrayList books;
    MyArrayList printEditions;
    MyArrayList printEditionsHasReaders;
    MyArrayList printEditionsCurrentAuthor;
    MyArrayList printEditionsCurrentYear;
    MyArrayList blackLists;
    int countBooks = 0;
    int countPrintEditions = 0;
    int counReaderPrintEditions;
    int countReaders = 0;

    public Library() {
        this.readers = new MyArrayList();
        this.printEditions = new MyArrayList();
        this.printEditionsHasReaders = new MyArrayList();
        this.blackLists = new MyArrayList();
        this.printEditionsCurrentAuthor = new MyArrayList();
        this.printEditionsCurrentYear = new MyArrayList();
    }

    public boolean addReader(Reader reader) {
        readers.add(reader);
        countReaders++;
        return true;
    }

    public boolean addPrintEdition(PrintEdition printEdition) {
        printEditions.add(printEdition);
        countPrintEditions++;
        return true;
    }

    public String showReaders() {
        System.out.println("Readers:");
        return readers.toString();
    }

    public String showPrinEdtitions() {
        System.out.println("Print Editions:");
        return printEditions.toString();
    }

    public boolean isPrintEditionAvailable(PrintEdition printEdition) {
        return printEditions.contains(printEdition);
    }

    public boolean givePrintEditionForReader(PrintEdition printEdition, Reader reader) {
        if (checkReader(reader)) return false;
        if (!isPrintEditionAvailable(printEdition)) return false;
        if (counReaderPrintEditions == 3 || counReaderPrintEditions > 3) return false;
        printEditionsHasReaders.add(printEdition);
        counReaderPrintEditions++;
        for (int i = 0; i < readers.size(); i++) {
            if ((readers.get(i) != null)) {
                if (readers.get(i).equals(reader)) {
                    reader.addPrintEditionForReader(printEdition);
                    return true;
                }
            }

        }

        return false;
    }

    public String showReadersPrinEdtitions() {
        System.out.println("Reader's print editions:");
        return printEditionsHasReaders.toString();
    }

    public String showCurrentReaderPrinEdtitions(Reader reader) {
        System.out.println(reader.getName() + "'s print editions:");
        return reader.showReaderPrintEditions();
    }

    public boolean addReaderToBlackList(Reader reader){
        if(!checkReader(reader)) blackLists.add(reader);
        return true;
    }

    public boolean checkReader(Reader reader){
        return blackLists.contains(reader);
    }
    //System.out.println(printEditions.get(i));

    public String showPrintEditionCurrentAuthor(Author author) {

        for (int i = 0; i < printEditions.size(); i++) {
            PrintEdition tmp = (PrintEdition) printEditions.get(i);
            if(tmp.getAuthor().equals(author)){
                printEditionsCurrentAuthor.add(tmp);
            }

        }
        return printEditionsCurrentAuthor.toString();
    }

    public String showPrintEditionCurrentYear(int year) {

        for (int i = 0; i < printEditions.size(); i++) {
            PrintEdition tmp = (PrintEdition) printEditions.get(i);
            if(tmp.getYear() == year){
                printEditionsCurrentYear.add(tmp);
            }

        }
        return printEditionsCurrentYear.toString();
    }

//    public void sortReaders(Comparator comparator){
//        for(int i =0; i<readers.size(); i++){
//            for(int j=0; j<readers.size()-1; j++){
//                int res = comparator.compare(readers.get(i), readers.get(i+1));
//                if(res>0){
//                    Reader tmp = (Reader) readers.get(i);
//                    Reader readerI  = (Reader) readers.get(i);
//                    Reader ReaderI1 = (Reader) readers.get(i +1);
//
//                    readerI = ReaderI1;
//                    ReaderI1 = tmp;
//                }
//            }
//        }
//    }
    //cmd + N
    @Override
    public String toString() {
        return readers.toString() + printEditions.toString();
    }
}
