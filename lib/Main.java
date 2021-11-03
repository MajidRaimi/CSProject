package lib;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> arrUsers = new ArrayList<User>();

    public static void main(String[] args) throws Exception {

        OS.readFile("Database.csv");

        System.out.print("Please Enter How Many Users Do You Want To Add : ");
        int howMany = scanner.nextInt();

        for (int i = 0; i < howMany; i++) {
            System.out.print("Please Enter Your Full Name : ");
            scanner.nextLine();
            String fullName = scanner.nextLine();
            fullName = fullName.trim();
            String[] arrFullName = fullName.split(" ");
            System.out.print("Please Enter Your Balance : ");
            double balance = scanner.nextDouble();
            System.out.print("Please Enter Your Card Number : ");
            String cardNumber = scanner.next();
            System.out.print("Please Enter Your PIN Number : ");
            int pinNumber = scanner.nextInt();

            arrUsers.add(new User(arrFullName[0], arrFullName[1], arrFullName[2], balance, cardNumber, pinNumber));

        }

        OS.writeFile("Database.csv");
        scanner.close();
    }

} // you're welcome majid !!!