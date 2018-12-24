package basic.adclass.ExperimentExtends;

public class TestCheckAccount {
    public static void main(String[] args){
        CheckAccount acc = new CheckAccount(1122,20000,0.045,5000);
        acc.withdrwa(5000);
        System.out.println("账户余额为： " + acc.getBalance());
        System.out.println("可透支额" + acc.getOverdraft());
        acc.withdrwa(18000);
        System.out.println("账户余额为： " + acc.getBalance());
        System.out.println("可透支额" + acc.getOverdraft());
        acc.withdrwa(3000);
        System.out.println("账户余额为： " + acc.getBalance());
        System.out.println("可透支额" + acc.getOverdraft());

    }
}
