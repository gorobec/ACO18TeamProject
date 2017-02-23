package model;

import exception.InvalidInputParameters;
import utils.RegEx;

/**
 * Created by v21k on 19.02.17.
 */
public class Address {
    private String city;
    private String street;
    private int number;

    public Address() {
    }

    public Address(String city, String street, int number) throws InvalidInputParameters {
        if (city != null && street != null && number > 0
                && city.trim().matches(RegEx.ONLY_ALPHA)
                && street.trim().matches(RegEx.ONLY_ALPHA)) {
            this.city = city;
            this.street = street;
            this.number = number;
        } else {
            throw new InvalidInputParameters("Wrong address");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (number != address.number) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return street != null ? street.equals(address.street) : address.street == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return String.format("City: %10s, street: %10s, house number: %d", city, street, number);
    }
}
