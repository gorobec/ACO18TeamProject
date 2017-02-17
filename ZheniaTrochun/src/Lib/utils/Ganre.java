package utils;

/**
 * Created by zhenia on 03.02.17.
 */
public enum Ganre {
    ROMAN("Roman"),
    DETECTIVE("Detective"),
    MUSICLE("Musicle"),
    MANUAL("Manual");

    private String name;
    Ganre(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
