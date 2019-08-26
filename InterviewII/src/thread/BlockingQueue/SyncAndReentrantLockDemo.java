package thread.BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HongbinW
 * @Date: 2019/8/19 23:04
 * @Version 1.0
 * @Description:
 * 多线程之间按顺序调用，实现A -> B -> C三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * ....
 * 来10轮
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++)
                shareResource.print5();
        },"AA").start();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++)
                shareResource.print10();
        },"BB").start();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++)
                shareResource.print15();
        },"CC").start();
    }
}

class ShareResource{
    String flag = "AA";
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5(){
        lock.lock();
        try{
            while (!flag.equals("AA")){
                c1.await();
            }
            for (int j = 0 ; j < 5; j ++){
                System.out.println(Thread.currentThread().getName() + "\t" + (j+1));
            }
            flag = "BB";
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            while (!flag.equals("BB")){
                c2.await();
            }
            for (int j = 0 ; j < 10; j ++){
                System.out.println(Thread.currentThread().getName() + "\t" + (j+1));
            }
            flag = "CC";
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            while (!flag.equals("CC")){
                c3.await();
            }
            for (int j = 0 ; j < 15; j ++){
                System.out.println(Thread.currentThread().getName() + "\t" + (j+1));
            }
            flag = "AA";
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
