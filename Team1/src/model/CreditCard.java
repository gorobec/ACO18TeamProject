package model;

import java.time.YearMonth;
import java.util.Date;

/**
 * Created by v21k on 20.02.17.
 */
public class CreditCard {
    private int number;
    private int cvv2;
    private YearMonth validUntil;

    public CreditCard() {
    }

    public CreditCard(int number, int cvv2, YearMonth validUntilYear) {
        this.number = number;
        this.cvv2 = cvv2;
        this.validUntil = validUntilYear;
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

    public YearMonth getValidUntilYear() {
        return this.validUntil;
    }

    public void setValidUntilYear(YearMonth validUntilYear) {
        this.validUntil = validUntilYear;
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

    @Override
    public String toString() {
        return String.format("Number: %s, valid until :%s\n", number, validUntil.toString());
    }
}
