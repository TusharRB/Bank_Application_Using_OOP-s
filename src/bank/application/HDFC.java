package bank.application;

import java.util.UUID;

public class HDFC implements BankInterface {

    private String password;
    private int balance;
    private String accountNo;
    public String name;
    public static double rateOfInterest;



    public HDFC(String password, int balance, String name) {

        this.accountNo = UUID.randomUUID().toString();
        this.password = password;
        this.balance = balance;
        this.name = name;
    }

    @Override
    public int checkBalance(String password) {

        if(password == this.password){
            return balance;
        }
        return -1;
    }

    @Override
    public String addMoney(int money) {

        balance = balance + money;

        String message = money + " has been credited to your account " + " "+ " the total balance is " + balance;

        return message;
    }

    @Override
    public String withDrawMoney(int drawMoney, String password) {

        if(password == this.password) {
            if (drawMoney > balance) {
                return "Insufficient Balance to your account";
            }
            else {

                balance = balance - drawMoney;

                return "Remaining Balance is" + balance;
            }
        }
        else {
            return "wrong password";
        }

    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {

        if(this.password.equals(oldPassword)){

            this.password = newPassword;

            return "Password update Successfully";
        }
        else{
            return "You entered wrong password";
        }
    }

    @Override
    public Double calculateTotalInterest(int years) {

        double interest = balance *  rateOfInterest * years / 100;

        return interest;
    }
}
