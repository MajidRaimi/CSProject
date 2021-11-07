package lib;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

abstract public class Sys extends Main {

    public static void runApp() throws Exception {
        System.out.println("Welcome To Group 4 ATM");
        System.out.println("1 - Login To Your Account");
        System.out.println("2 - Make A New Account");
        System.out.println("0 - Exit");

        System.out.print("What Would You Like To Do : ");

        try {
            int choice = scanner.nextInt();

            OS.clrscr();

            switch (choice) {
            case 1:
                runLogIn(-1);
                break;
            case 2:
                SignUp.makeAccount();
            case 0:
                // ! Just To Exit
                OS.clrscr();
                OS.loadingBar(4);
                System.out.println("Thank You For Using Our ATM\nCome Back Soon");
                break;
            default:
                runError(ErrorTypes.WrongInput);

            }

        } catch (Exception e) {
            OS.clrscr();
            //System.out.println("Please Restart The System And Try Again");
        }

    }

    public static void runLogIn(int i) throws Exception {
        OS.clrscr();
        int index;
        if (i < 0) {
            index = Auth.login();
        } else {
            index = i;
        }

        OS.clrscr();

        System.out.println("Welcome " + arrUsers.get(index).getFName());
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Display Account Info");
        System.out.println("0 - Logout");
        System.out.print("What Would You Like To Do : ");
        int choice = scanner.nextInt();

        OS.clrscr();

        switch (choice) {
        case 1:
            SignIn.depositToAccount(index);
            break;
        case 2:
            SignIn.withdrawToAccount(index);
            break;
        case 3:
            SignIn.displayInfo(index);
            break;
        case 0:
            index = -1;
            OS.clrscr();
            runApp();

        }
        if (index >= 0)
            runLogIn(index);

    }

    public static void runError(ErrorTypes errorType) throws Exception {

        String errorTypeString = "Wrong Input";

        switch (errorType) {
        case WrongInput:
            break;
        case WrongPinNumber:
            errorTypeString = "Wrong PIN Number";
            break;
        case WrongCardNumber:
            errorTypeString = "Wrong Card Number";
            break;
        case NoAccount:
            errorTypeString = "Your Account Was Not Found.\nCreate A New Account. ";
        }

        OS.clrscr();
        System.out.print(errorTypeString + "\nPlease Try Again");
        OS.changeConsoleColor(4);
        TimeUnit.SECONDS.sleep(3);
        OS.clrscr();
        OS.changeConsoleColor(7);
        runApp();

    }

}
