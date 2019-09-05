package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 10:13
 * @Version 1.0
 * @Description:
 */
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t" + "get" + lockA);
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t" + "get" + lockB);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadB").start();
    }
}
