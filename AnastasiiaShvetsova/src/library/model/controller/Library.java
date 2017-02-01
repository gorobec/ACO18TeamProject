package library.model.controller;
import library.model.*;
import data_structures.MyArrayList;
/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Library implements AddItemAble{
    MyArrayList readers;
    MyArrayList books;
    MyArrayList printEditions;
    MyArrayList printEditionsHasReaders;
    BlackList blackList;
    int countBooks = 0;
    int countPrintEditions = 0;
    int countReaders = 0;

    public Library(){
        this.readers = new MyArrayList();
        this.printEditions = new MyArrayList();
    }
    public boolean addReader(Reader reader){
        readers.add(reader);
        return true;
    }
    public boolean addPrintEdition(PrintEdition printEdition){
        printEditions.add(printEdition);
        return true;
    }

    //public String showObjects(Object ob)
    //cmd + N
    @Override
    public String toString() {
        return readers.toString() + printEditions.toString();
    }
}
