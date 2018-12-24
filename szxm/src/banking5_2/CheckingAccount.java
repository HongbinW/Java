package banking5_2;

//信用卡账户
public class CheckingAccount extends Account {
//    private double protectedBy; //透支额度
    SavingAccount protectedBy;  //储蓄卡的透支额度

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, SavingAccount protectedBy) {
        super(balance);
        this.protectedBy = protectedBy;
    }

    public SavingAccount getProtectedBy() {
        return protectedBy;
    }

    public void setProtectedBy(SavingAccount protectedBy) {
        this.protectedBy = protectedBy;
    }

    public boolean withdraw(double n) {
        if(balance >= n){
            balance -= n;
            return false;
        }else if(protectedBy != null && protectedBy.getBalance() >= n - balance){
            protectedBy.withdraw(n - balance);
            balance = 0;
            return true;
        }else {
            return false;
        }
    }
}
