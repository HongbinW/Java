package banking;

public class Account {
    private double balance;
    public Account(double i){
        balance = i;
    }
    public double getBalance(){
        return balance;
    }
    //存钱
    public void deposit(double a){
        balance += a;
    }
    //取钱
    public void withdraw(double n){
        if (balance >= n){
            balance -= n;
        }else {
            System.out.println("余额不足");
        }

    }
}
