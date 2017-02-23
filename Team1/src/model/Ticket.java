package model;

/**
 * Created by v21k on 19.02.17.
 */
public class Ticket {
    private int id;
    private BankCard bankCard;
    private Address address;
    private int productID;

    public Ticket(int id, BankCard bankCard, Address address, int productID) {
        this.id = id;
        this.bankCard = bankCard;
        this.address = address;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
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
        return String.format("ID: %d, address: %s, product id: %d\n", id, address.toString(), productID);
    }

    public int getProductID() {
        return productID;
    }
}