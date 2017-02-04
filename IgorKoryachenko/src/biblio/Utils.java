package biblio;

import week1.homeWork.implementAL.ArrList;

import java.util.Comparator;

/**
 * Created by Игорь on 03.02.2017.
 */
public class Utils {

    public static ArrList sort(ArrList arrList, Comparator comparator){
        ArrList arr = arrList;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (comparator.compare(arr.get(i), arr.get(i + 1)) > 0){
                    Object temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i, temp);
                }
            }
        }
        return arr;
    }
}
