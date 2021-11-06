package lib;

import java.util.*;
import java.util.concurrent.TimeUnit;

enum ErrorTypes {
    WrongInput, WrongPinNumber, WrongCardNumber, NoAccount
}

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> arrUsers = new ArrayList<User>();

    public static void main(String[] args) throws Exception {

        OS.readFile("Database.csv");
        Sys.runApp();
        OS.writeFile("Database.csv");
        scanner.close();
    }

}