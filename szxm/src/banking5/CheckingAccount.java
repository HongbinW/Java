package banking5;
//信用卡账户
public class CheckingAccount extends Account {
    private double overdraftProtection; //透支额度

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    public boolean withdraw(double n) {
        if (balance >= n) {
            balance -= n;
            return true;
        }
        else if (overdraftProtection >= n - balance){
            overdraftProtection -= (n - balance);
            balance = 0;
            return true;
        }else
            return false;
    }
}
