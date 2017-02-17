package utils;

/**
 * Created by zhenia on 03.02.17.
 */
public enum EditionType{
    MAGAZINE(0), NEWSPAPER(1), BOOK(2);

    private final int i;

    EditionType(int i){
        this.i = i;
    }

    public int getVal() {
        return i;
    }
}
