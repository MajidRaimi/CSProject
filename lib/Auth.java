package lib;

import java.util.*;

abstract public class Auth extends Main {

    public static boolean validPinNumber(int pinNumber) {
        return (int) Math.floor(Math.log10(pinNumber) + 1) == 4;
    }

    public static boolean validCardNumber(String cardNumber) {
        return cardNumber.length() == 8;
    }

    public static int validAccount(String cardNumber, int pinNumber) {
        int index = -1;

        for (int i = 0; i < arrUsers.size(); i++) {
            if (arrUsers.get(i).getCardNumber().equals(cardNumber)
                    && arrUsers.get(i).getCardPIN() == pinNumber) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static int login() throws Exception {

        String cardNumber;
        int pinNumber;

        System.out.print("Please Enter Your Card Number : ");
        cardNumber = scanner.next();
        System.out.print("Please Enter Your PIN Number  : ");
        pinNumber = scanner.nextInt();

        int index = -1;
        if (validCardNumber(cardNumber)) {
            if (validPinNumber(pinNumber)) {
                if (0 <= validAccount(cardNumber, pinNumber)) {
                    index = validAccount(cardNumber, pinNumber);
                } else {
                    Sys.runError(ErrorTypes.NoAccount);
                }
            } else {
                Sys.runError(ErrorTypes.WrongPinNumber);
            }
        } else {
            Sys.runError(ErrorTypes.WrongCardNumber);
        }

        return index;
    }

}
