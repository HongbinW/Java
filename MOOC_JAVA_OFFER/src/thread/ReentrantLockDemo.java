package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HongbinW
 * @Date: 2019/8/4 19:34
 * @Version 1.0
 * @Description:
 */
public class ReentrantLockDemo implements Runnable{
    private static ReentrantLock lock = new ReentrantLock(false);

    public void run(){
        while (true){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " get lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo  = new ReentrantLockDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
    }
}
