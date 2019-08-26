package thread.BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HongbinW
 * @Date: 2019/8/19 22:25
 * @Version 1.0
 * @Description:
 *
 * 一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，执行五次
 */

//高内聚、低耦合（尽量解耦），线程操作资源类
//判断、干活、唤醒通知
//严防多线程并发下的虚假唤醒（用while不要用if）
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args){
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i ++){
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i ++){
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}

class ShareData{    //资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() throws Exception{
        lock.lock();
        try{
            //1.判断
            while (number != 0){
                //等待，不能生产
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrease() throws Exception{
        lock.lock();
        try{
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
