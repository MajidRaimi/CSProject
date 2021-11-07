package lib;

public class Security {

    public static void encryptAll() {

        for (int i = 0; i < Main.arrUsers.size(); i++) {
            Main.arrUsers.get(i).setCardNumber(encryptCardNumber(Main.arrUsers.get(i).getCardNumber()));
            Main.arrUsers.get(i).setCardPIN(encryptPinNumber(Main.arrUsers.get(i).getCardPIN()));
        }

    }

    private static String encryptCardNumber(String n) {
        String e = "";
        for (int i = 0; i < n.length(); i++) {
            Character c = n.charAt(i);
            if (Character.isLowerCase(n.charAt(i))) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            c = (char) (c + 10);
            e += c + "";
        }

        return e;
    }

    private static int encryptPinNumber(int n) {
        String e = "";
        String nString = n + "";

        for (int i = 0; i < nString.length(); i++) {
            Character c = nString.charAt(i);
            if (Character.isLowerCase(nString.charAt(i))) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            c = (char) (c + 10);
            e += c + "";
        }

        return Integer.parseInt(e);
    }

    public static void decryptAll() {

        for (int i = 0; i < Main.arrUsers.size(); i++) {
            Main.arrUsers.get(i).setCardNumber(decryptCardNumber(Main.arrUsers.get(i).getCardNumber()));
            Main.arrUsers.get(i).setCardPIN(decryptPinNumber(Main.arrUsers.get(i).getCardPIN()));
        }

    }

    private static String decryptCardNumber(String n) {
        String e = "";
        for (int i = 0; i < n.length(); i++) {
            Character c = n.charAt(i);
            if (Character.isLowerCase(n.charAt(i))) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            c = (char) (c - 10);
            e += c + "";
        }

        return e;
    }

    private static int decryptPinNumber(int n) {
        String e = "";
        String nString = n + "";

        for (int i = 0; i < nString.length(); i++) {
            Character c = nString.charAt(i);
            if (Character.isLowerCase(nString.charAt(i))) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            c = (char) (c - 10);
            e += c + "";
        }

        return Integer.parseInt(e);
    }

}
