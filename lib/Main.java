package lib;

import java.util.*;
import java.util.concurrent.TimeUnit;

enum ErrorTypes {
    WrongInput, WrongPinNumber, WrongCardNumber, NoAccount
}

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Customer> arrUsers = new ArrayList<Customer>();

    public static void main(String[] args) throws Exception {

        OS.readFile("Database.csv");
        Security.decryptAll();
        Sys.runApp();
        Security.decryptAll();
        OS.writeFile("Database.csv");
        scanner.close();
    }

}