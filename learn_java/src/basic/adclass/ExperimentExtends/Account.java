package basic.adclass.ExperimentExtends;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public double getMonthlyInterest(){
        return this.annualInterestRate/12;
    }
    public void withdrwa(double amount){
        if(this.balance <= amount){
            System.out.println("余额不足!");
        }else{
            balance -= amount;
//            System.out.println("取款: " + amount);
        }
    }
    public void deposit(double amount){
        balance += amount;
    }
}
