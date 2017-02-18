package library.model.comparators;

import library.model.PrintEdition;

import java.util.Comparator;

/**
 * Created by Nastia on 01.02.17.
 */
public class ComparatorPrintEditionByName  implements Comparator {
    @Override
    public int compare(Object obj1, Object obj2){
        PrintEdition printEdition1 = (PrintEdition) obj1;
        PrintEdition printEdition2 = (PrintEdition) obj2;

        return printEdition1.getName().compareTo(printEdition2.getName());
    }
}
