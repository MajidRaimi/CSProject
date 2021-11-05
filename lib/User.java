package lib;

public class User {

    private String fName;
    private String sName;
    private String lName;
    private double balance;
    private String cardNumber;
    private int cardPIN;

    public User(String fName, String sName, String lName, double balance, String cardNumber, int cardPIN) {
        this.fName = fName;
        this.sName = sName;
        this.lName = lName;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cardPIN = cardPIN;
    }

    public String getFName() {
        return this.fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return this.sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getLName() {
        return this.lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardPIN() {
        return this.cardPIN;
    }

    public void setCardPIN(int cardPIN) {
        this.cardPIN = cardPIN;
    }

    public String fullName(){
        return this.fName + " " + this.sName + " " + this.lName ;  
    }


    public void deposit(double money){
        balance += money ; 
    }


    public void withdraw(double money){
        balance -= money ; 
    }


}
