package com.bestBuy.to;

import com.bestBuy.model.CardType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Администратор on 20.02.2017.
 */
public class Validator {

    public static boolean validEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-z0-9_.]+@[a-z0-9_]+\\.[a-z]{2,5}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validPassword(String password) {
        Pattern pattern = Pattern.compile("^[a-z0-9_.]{6,30}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validCreditCard(String creditCard) {
        if (CardType.detect(creditCard) == CardType.UNKNOWN || !validCardByAlgorithm(creditCard)) {
            return false;
        }
        return true;
    }

    // http://stackoverflow.com/questions/20377978/credit-card-type-and-validation
    private static boolean validCardByAlgorithm(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}
