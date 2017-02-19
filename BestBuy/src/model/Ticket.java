package model;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class Ticket {

    private int id;
    private String adress;
    private int creditCard;

    public Ticket() {}

    public Ticket(int id, String adress, int creditCard) {
        this.id = id;
        this.adress = adress;
        this.creditCard = creditCard;
    }


}
