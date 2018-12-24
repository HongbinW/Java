package basic.adclass.ExperimentExtends;

public class CheckAccount extends Account{
    private double overdraft;

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public void withdrwa(double amount){
        if(amount <= this.getBalance()) {
            this.setBalance(this.getBalance() - amount);
        }else{
            if(this.getBalance() + this.overdraft > amount){
                this.overdraft = this.overdraft + this.getBalance() - amount;
                this.setBalance(0);
            }else{
                System.out.println("超过可透支额的限额");
            }
        }
    }
}
