package lib;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

abstract public class SignUp extends Main {

    public static void makeAccount() throws Exception {
        OS.clrscr();
        String fName, sName, lName, cardNumber = "";
        int pinNumber;

        for (int i = 0; i < 8; i++) {
            cardNumber += random.nextInt(9);
        }

        System.out.print("Please Enter Your First Name     : ");
        fName = scanner.next();
        System.out.print("Please Enter Your Second Name    : ");
        sName = scanner.next();
        System.out.print("Please Enter Your Last Name      : ");
        lName = scanner.next();

        pinNumber = pinCheck() ; 

        arrUsers.add(new Customer(fName, sName, lName, 0, cardNumber, pinNumber)) ; 

        OS.clrscr();
        System.out.println("Your Card Number : " + cardNumber );
        System.out.print("Enter Anything To Go To The Main Menu");
        scanner.nextLine() ; 
        scanner.nextLine() ; 
        OS.clrscr();



        Sys.runApp() ; 
    }

    public static int pinCheck() throws InterruptedException {

        int pinNumber = 0, confirm = 1;

        while (true) {
            System.out.print("Please Enter Your PIN Number     : ");
            pinNumber = scanner.nextInt();
            System.out.print("Please Enter It Again To Confirm : ");
            confirm = scanner.nextInt();
            if(pinNumber != confirm){
                OS.clrscr() ; 
                System.out.println("The PIN Number And The Conformation Does Not Equal !\nPlease Try Again");
                TimeUnit.SECONDS.sleep(6);
            } else {
                break ; 
            }
        }

        return pinNumber;

    }





}
