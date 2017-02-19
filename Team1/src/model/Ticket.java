package model;

/**
 * Created by v21k on 19.02.17.
 */
public class Ticket {
    private int id;
    private String creditCard;
    private Address address;

    public Ticket() {
    }


    public Ticket(int id, String creditCard, Address address) {
        this.id = id;
        this.creditCard = creditCard;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, address: %s\n", id, address.toString());
    }
}
