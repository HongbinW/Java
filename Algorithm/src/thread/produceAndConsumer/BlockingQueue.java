package thread.produceAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: HongbinW
 * @Date: 2019/8/27 21:22
 * @Version 1.0
 * @Description:
 */
public class BlockingQueue {
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++) {
                myResource.increase();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++){
                myResource.decrease();
            }
        },"B").start();
    }
}
class MyResource{
    private int number;
    AtomicInteger atomicInteger = new AtomicInteger(1);
    ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

    public void increase(){

        number ++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        try {
            blockingQueue.offer(number,200,TimeUnit.MILLISECONDS);
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decrease(){
        try {
            number = blockingQueue.poll(200,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number --;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
