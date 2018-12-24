package basic.adclass.ExperimentExtends;

public class TestAccount {
    public static void main(String[] args){
        Account ac = new Account(1112,20000,0.045);
        ac.withdrwa(30000);
        System.out.println("当前账户余额为: " + ac.getBalance());
        ac.withdrwa(2500);
        ac.deposit(3000);
        System.out.println("当前账户余额为: " + ac.getBalance());
        System.out.println("月利率为: " + ac.getMonthlyInterest());
    }
}
