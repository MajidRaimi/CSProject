package lib;

import java.util.concurrent.TimeUnit;

public class Admin extends User {

    public static void getCardNumber() throws Exception {
        OS.clrscr();
        OS.changeConsoleColor(3);
        System.out.println("Welcome To Admin Menu.");
        System.out.print("Search For Costumer By Card Number : ");
        String cardNumber = Main.scanner.next();
        adminMenu(cardNumber);
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
        System.out.println("1 - Display Info");
        System.out.println("2 - Edit PIN Code");
        System.out.println("0 - LogOut");
        System.out.print("What Would You Like To Do : ");
        int choice = Main.scanner.nextInt();

        switch (choice) {
        case 1:
            SignIn.displayInfo(index);
            adminMenu(Main.arrUsers.get(index).getCardNumber());
            break;
        case 2:
            editPinNumber(index);
            break;
        case 0:
            OS.clrscr() ; 
            OS.changeConsoleColor(7) ; 
            Sys.runApp();

            break;
        default:
            adminMenu(Main.arrUsers.get(index).getCardNumber());
        }

    }

    public static void editPinNumber(int index) throws Exception {
        OS.clrscr() ; 
        System.out.print("Please Enter New PIN Code : ");
        int newPin = Main.scanner.nextInt();
        Main.arrUsers.get(index).setCardPIN(newPin);

        OS.clrscr();
        System.out.println("Done Changing PIN Code To : " + newPin);
        System.out.println("Press Anything To Return To Menu");
        Main.scanner.nextLine();
        Main.scanner.nextLine();
        Admin.adminMenu(Main.arrUsers.get(index).getCardNumber());
    }

}
