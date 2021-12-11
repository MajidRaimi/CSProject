package lib;

import java.util.concurrent.TimeUnit;

public class Admin extends User {

    public static void getCardNumber() throws Exception {
        OS.clrscr();
        OS.changeConsoleColor(3);
        System.out.println("Welcome To Admin Menu.");

        for (int i = 0; i < Main.arrUsers.size(); i++) {
            System.out.println("( Index : " + i + " ) --> " + Main.arrUsers.get(i).fullName());
        }

        System.out.print("Please Enter Costumer Index ( -1 To Exit ) : ");

        int index = Main.scanner.nextInt();

        if (index == -1) {
            OS.clrscr();
            Sys.runApp();
        } else if (0 <= index && index < Main.arrUsers.size()) {
            adminLogin(index);
        } else {
            OS.clrscr();
            System.out.println("Wrong Index \nPlease Try Again !");
            TimeUnit.SECONDS.sleep(3);
            getCardNumber();
        }

    }

    public static void adminMenu(String cardNumber) throws Exception {

        if (costumerIndex(cardNumber) >= 0) {
            adminLogin(costumerIndex(cardNumber));
        } else {
            OS.clrscr();
            System.out.println("Wrong Card Number\nPlease Try Again");
            TimeUnit.SECONDS.sleep(4);
            adminMenu(cardNumber);
        }

    }

    public static int costumerIndex(String cardNumber) {
        int index = -1;
        for (int i = 0; i < Main.arrUsers.size(); i++) {
            if (Main.arrUsers.get(i).getCardNumber().equals(cardNumber)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void adminLogin(int index) throws Exception {
        OS.clrscr();
        System.out.println("You Are Editing " + Main.arrUsers.get(index).getFName() + "'s Account");
        System.out.println("1 - Display Info .");
        System.out.println("2 - Edit PIN Code .");
        System.out.println("3 - Display Private Info .");
        System.out.println("4 - Delete Account .");
        System.out.println("0 - LogOut .");
        System.out.print("What Would You Like To Do : ");
        int choice = Main.scanner.nextInt();

        switch (choice) {
        case 1:
            SignIn.displayInfo(index);
            adminLogin(index);
            break;
        case 2:
            editPinNumber(index);
            adminLogin(index);
            break;

        case 3:
            OS.clrscr();
            System.out.println("Card Number : " + Main.arrUsers.get(index).getCardNumber());
            System.out.println("Pin Number : " + Main.arrUsers.get(index).getCardPIN());
            System.out.print("Press Anything To Exit ");
            Main.scanner.nextLine();
            Main.scanner.nextLine();
            adminLogin(index);
            break;

        case 4:
            Main.arrUsers.remove(index);
        case 0:
            OS.clrscr();
            OS.changeConsoleColor(7);
            Sys.runApp();
            
            break;
        default : 
            adminLogin(index);
        }


    }

    public static void editPinNumber(int index) throws Exception {
        OS.clrscr();
        System.out.print("Please Enter New PIN Code : ");
        int newPin = Main.scanner.nextInt();
        Main.arrUsers.get(index).setCardPIN(newPin);

        OS.clrscr();
        System.out.println("Done Changing PIN Code To : " + newPin);
        System.out.println("Press Anything To Return To Menu");
        Main.scanner.nextLine();
        Main.scanner.nextLine();
        Admin.adminLogin(index);
    }

}
