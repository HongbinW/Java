package thread.produceAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HongbinW
 * @Date: 2019/8/27 21:08
 * @Version 1.0
 * @Description:
 */
public class ReentrantLockAwaitSignal {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++)
                resource.increase();
        },"AA").start();
        new Thread(()->{
            for (int i = 0 ;i < 10; i ++)
                resource.decrease();
        },"BB").start();
    }
}
class Resource{
    private int number = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase(){
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrease(){
        lock.lock();
        try{
            while (number == 0){
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
