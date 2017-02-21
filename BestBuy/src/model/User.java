package model;

/**
 * Created by Администратор on 21.02.2017.
 */
public class User {

    private String email;
    private String password;
    private String creditCard;
    private String address;

    public User(String email, String password, String creditCard, String address) {
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.address = address;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (creditCard != null ? !creditCard.equals(user.creditCard) : user.creditCard != null) return false;
        return address != null ? address.equals(user.address) : user.address == null;
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (creditCard != null ? creditCard.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
