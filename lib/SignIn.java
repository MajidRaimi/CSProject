package lib;

import java.util.concurrent.TimeUnit;

public class SignIn extends Main {

    public static void displayInfo(int index) {
        System.out.println("Your Full Name : " + arrUsers.get(index).fullName());
        System.out.println("Your Balance   : " + arrUsers.get(index).getBalance());
        //System.out.printf("Your Balance : %,d \n" , arrUsers.get(index).getBalance()) ; 
        System.out.print("Press AnyThing To Exit ");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void depositToAccount(int index) {

        System.out.print("Please Enter Your Money : ");
        double money = scanner.nextDouble();
        arrUsers.get(index).deposit(money) ;
        System.out.print("Press AnyThing To Exit ");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void withdrawToAccount(int index) throws InterruptedException{

        System.out.print("Please Enter Your Money : ");
        double money = scanner.nextDouble() ;
        
        if(arrUsers.get(index).getBalance() < money){
            OS.clrscr() ; 
            System.out.println("You Have Only "  + arrUsers.get(index).getBalance() );
            System.out.println("Please Try To Withdraw Less Than " + money);
            TimeUnit.SECONDS.sleep(6);
            
        } else {
            arrUsers.get(index).withdraw(money);
        }

    }



}
