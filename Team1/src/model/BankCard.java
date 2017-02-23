package model;

import exception.InvalidInputParameters;
import utils.RegEx;

import java.time.YearMonth;

/**
 * Created by v21k on 20.02.17.
 */
public class BankCard {
    private String number;
    private int cvv2;
    private YearMonth validUntil;

    public BankCard() {
    }

    public BankCard(String number, int cvv2, YearMonth validUntilYear) throws InvalidInputParameters {
        if (number != null
                && cvv2 > 99 && cvv2 < 1000
                && validUntilYear != null
                && number.matches(RegEx.ONLY_NUMERIC)
                && number.length() == 16) {
            this.number = number;
            this.cvv2 = cvv2;
            this.validUntil = validUntilYear;
        } else {
            throw new InvalidInputParameters("Wrong credit card info.");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

        BankCard bankCard = (BankCard) o;

        if (number != null ? !number.equals(bankCard.number) : bankCard.number != null) return false;
        return validUntil != null ? validUntil.equals(bankCard.validUntil) : bankCard.validUntil == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Number: %s, valid until :%s\n", number, validUntil.toString());
    }
}
