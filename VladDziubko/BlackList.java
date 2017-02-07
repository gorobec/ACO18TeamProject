package week2.library.blacklist;

import week2.library.readers.Reader;

import java.util.ArrayList;

public class BlackList {
    private ArrayList<Reader> blackList = new ArrayList<>();

    // 8) добавить читателя в черный список (ему нельзя выдавать печатные издания)
    public boolean addToBL(Reader reader){
        if(reader == null){
            return false;
        }
        return blackList.add(reader);
    }

    // remove reader from BL
    public boolean removeFromBL(Reader reader){
        if(reader == null){
            return false;
        }
        return blackList.remove(reader);
    }

    // show readers in BL for test purposes
    public ArrayList showReadersInBL(){
        for (int i = 0; i < blackList.size(); i++) {
            System.out.printf("%s %s\n", blackList.get(i).getName(), blackList.get(i).getSurname());
        }
        return blackList;
    }



}
