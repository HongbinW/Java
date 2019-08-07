package thread;

/**
 * @Author: HongbinW
 * @Date: 2019/8/3 22:01
 * @Version 1.0
 * @Description:
 */
public class WaitSleepDemo {
    public static void main(String[] args){
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(200);       //A睡眠时间超过10毫秒，因此主线程生成线程B，并执行B线程，但是睡眠时不释放锁，因此线程B依然在等待获得锁
                        System.out.println("thread A do wait method");
                        lock.wait();        //wait会释放锁，此时B会去获取锁
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(10);       //先让A线程执行，让主线程睡眠10毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10ms");
                        Thread.sleep(10);
                        lock.notifyAll();
//                        Thread.yield();   //yield并不会使当前线程释放锁
                        Thread.sleep(2000);
                        System.out.println("thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
