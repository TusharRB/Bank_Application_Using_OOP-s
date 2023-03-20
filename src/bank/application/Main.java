package bank.application;

public class Main {
    public static void main(String[] args) {


        SBI account1 = new SBI("123",32000,"Rahul");
        HDFC account2 = new HDFC("123",32000,"Rahul");

        SBI.rateOfInterest = 7;
        HDFC.rateOfInterest = 6;

        // Enter Wrong Password
        int balance = account1.checkBalance("12");
        System.out.println(balance);


        // Enter Correct Password
        int balance1 = account1.checkBalance("123");
        System.out.println(balance1);

        // SBI Bank Rate of Interest
        double result = account1.calculateTotalInterest(2);
        System.out.println(result);

        // HDFC Bank Rate of Interest
        double result1 = account2.calculateTotalInterest(2);
        System.out.println(result1);



    }
}