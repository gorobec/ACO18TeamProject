package model;

/**
 * Created by fmandryka on 19.02.2017.
 */
public class Ticket {

    private int id;
    private int productID;
    private String adress;
    private String creditCard;

    public Ticket() {}

    public Ticket(int id, int productID, String adress, String creditCard) {
        this.id = id;
        this.productID = productID;
        this.adress = adress;
        this.creditCard = creditCard;

    }

    public int getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public String  getCreditCard() {
        return creditCard;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", productID=" + productID +
                ", adress='" + adress + '\'' +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
