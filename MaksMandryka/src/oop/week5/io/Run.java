package oop.week5.io;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class Run {

    public static void main(String[] args) {
        MyBash mb = new MyBash("C:\\Users\\f.mandryka\\Documents\\Idea\\ACO18TeamProject\\MaksMandryka");

        System.out.println(mb.ls().toString());
    }

}
