package basic.multithreading;
//线程通信
//使用两个线程交替打印 1-100
/*
    线程通信
    wait():一旦一个线程执行到wait()，就会释放当前的锁
    notify():唤醒wait()的一个线程
    notifyAll():唤醒wait()的所有线程
    **此三个关键字只能在同步代码块或同步方法中使用**
 */
class PrintNumber implements Runnable{
    int num = 1;
    public void run(){
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class TestCommunication {
    public static void main(String[] args) {
        PrintNumber p = new PrintNumber();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}
