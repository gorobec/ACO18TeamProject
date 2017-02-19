package week3.day2.homeWork.changeList;
import java.lang.String;

public class ListUtils implements A {


    public void createStringList(){


    }

    public static A reversion(A node){
        //pai
        return node;
    }

     static void  pair(HalfNode node){
        if (node.next == null) return;
        HalfNode fst = node;
        HalfNode snd = fst.next;
        pair(snd);
        snd.next = fst;
        fst.next = null;

        //return fst;
    }



    @Override
    public void setNext(A next) {

    }

    @Override
    public A getNext() {

        return null;
    }

   /* public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }*/
}
