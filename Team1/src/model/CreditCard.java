package model;

/**
 * Created by v21k on 20.02.17.
 */
public class CreditCard {
    private int number;
    private int cvv2;
    private int validUntilYear;

    public CreditCard() {
    }

    public CreditCard(int number, int cvv2, int validUntilYear) {
        this.number = number;
        this.cvv2 = cvv2;
        this.validUntilYear = validUntilYear;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public int getValidUntilYear() {
        return validUntilYear;
    }

    public void setValidUntilYear(int validUntilYear) {
        this.validUntilYear = validUntilYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (number != that.number) return false;
        return cvv2 == that.cvv2;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + cvv2;
        return result;
    }
}
