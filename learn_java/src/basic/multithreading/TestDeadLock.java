package basic.multithreading;
//死锁问题：处理线程同步时，容易出现。
//（比如，有两个锁，而两个线程分别占着一个锁不放弃，等待对方释放，这样谁都无法进行下去）
//写代码时要避免死锁
public class TestDeadLock {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                synchronized (sb1){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("A");
                    synchronized (sb2){
                        sb2.append("B");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                synchronized (sb2){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("C");
                    synchronized (sb1){
                        sb2.append("D");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
    }
}
