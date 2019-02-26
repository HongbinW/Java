package basic.multithreading.exercise;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 拓展：实现二者的交替打印，使用线程的通信
 */

//class Account{
//    private int money = 0;
//    public Account(){}
//    public Account(int money){
//        this.money = money;
//    }
//    public void setMoney(int money){
//        this.money = money;
//    }
//    public int getMoney(){
//        return this.money;
//    }
//    public void saveMoney(int money){
//        this.money += money;
//        System.out.print(Thread.currentThread().getName() + "存入：" + money);
//        System.out.println("\t账户余额为：" + this.money);
//    }
//}
//class Bank implements Runnable{
//    private static Account bankAccount = new Account();
//
//    public void run(){
////        synchronized (this){
//
//        for(int i = 0; i < 3; i++){
//            synchronized (this) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e)  {
//                    e.printStackTrace();
//                }
//                bankAccount.saveMoney(1000);
//            }
//        }
//    }
//}
//public class TestBank{
//    public static void main(String[] args) {
//        Bank b = new Bank();
//        Thread t1 = new Thread(b);
//        Thread t2 = new Thread(b);
//        t1.setName("账户一");
//        t2.setName("账户二");
//        t1.start();
//        t2.start();
//    }
//}

class Account{
    int banlance;
    public synchronized void deposit(int money){
        notify();
        banlance += money;
        System.out.print(Thread.currentThread().getName() + "存入：" + money);
        System.out.println("\t当前账户余额为:" + banlance);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Customer extends Thread{
    Account acc;
//    static Object obj = new Object();
    public Customer(Account acc){
        this.acc = acc;
    }
    public void run(){
        for(int i = 0; i < 3; i++) {
//            synchronized (obj) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                acc.deposit(1000);
            }
//        }
    }
}
public class TestBank{
    public static void main(String[] args) {
        Account acc = new Account();
        Customer c1 = new Customer(acc);
        Customer c2 = new Customer(acc);
        c1.setName("账户一");
        c2.setName("账户二");
        c1.start();
        c2.start();
    }
}