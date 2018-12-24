package banking5_2;

public class Account {
    protected double balance;

    public Account(){

    }
    public Account(double i){
        balance = i;
    }
    public double getBalance(){
        return balance;
    }
    //存钱
    public boolean deposit(double a){
        balance += a;
        return true;
    }
    //取钱
    public boolean withdraw(double n){
        if (balance >= n){
            balance -= n;
            return true;
        }else {
            System.out.println("余额不足");
            return false;
        }
    }
}
