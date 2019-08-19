package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HongbinW
 * @Date: 2019/8/19 22:14
 * @Version 1.0
 * @Description:
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blocingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t put a");
                blocingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + "\t put b");  //不会立即执行到此，必须要等a被消费了，才会放入b
                blocingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "\t put c");
                blocingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + blocingQueue.take());

                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + blocingQueue.take());

                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + blocingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
