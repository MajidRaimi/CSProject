package lib;

public class Security {

    public static void encryptAll() {

        for (int i = 0; i < Main.arrUsers.size(); i++) {
            Main.arrUsers.get(i).setSName(encryptString(Main.arrUsers.get(i).getSName()));
            Main.arrUsers.get(i).setLName(encryptString(Main.arrUsers.get(i).getLName()));
            Main.arrUsers.get(i).setCardNumber(encryptString(Main.arrUsers.get(i).getCardNumber()));
        }

    }

    public static void decryptAll() {

        for (int i = 0; i < Main.arrUsers.size(); i++) {
            Main.arrUsers.get(i).setSName(decryptString(Main.arrUsers.get(i).getSName()));
            Main.arrUsers.get(i).setLName(decryptString(Main.arrUsers.get(i).getLName()));
            Main.arrUsers.get(i).setCardNumber(decryptString(Main.arrUsers.get(i).getCardNumber()));
        }

    }

    public static String encryptString(String str) {
        String e = "";

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }

            c = (char) (c + 10);
            e += c;

        }
        return e;
    }

    public static String decryptString(String str) {
        String d = "";

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }

            c = (char) (c - 10);
            d += c;

        }
        return d;
    }

}
