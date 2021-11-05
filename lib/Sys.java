package lib;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Sys extends Main {

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
                runLogIn();
                break;
            case 2:
                // TODO: Make New Account
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
            System.out.println("Please Restart The System And Try Again");
        }

    }

    public static void runLogIn() throws Exception {
        int index = Auth.login();

    }

    public static void runError(ErrorTypes errorType) throws Exception {

        String errorTypeString = "Wrong Input" ; 

        switch (errorType){
            case WrongInput :
                break ;
            case WrongPinNumber :
                errorTypeString = "Wrong PIN Number" ;
                break ;
            case WrongCardNumber :
                errorTypeString = "Wrong Card Number" ; 
                break ; 
            case NoAccount : 
                errorTypeString = "We Did Not Found Your Account\nTry To Make One" ;
        }

        OS.clrscr();
            System.out.print( errorTypeString +  "\nPlease Try Again");
            OS.changeConsoleColor(4);
            TimeUnit.SECONDS.sleep(3);
            OS.clrscr();
            OS.changeConsoleColor(7);
            runApp();




    }

}
