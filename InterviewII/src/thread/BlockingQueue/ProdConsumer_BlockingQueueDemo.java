package thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: HongbinW
 * @Date: 2019/8/21 19:58
 * @Version 1.0
 * @Description:
 *
 * 串用 volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args){
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线成启动");
            try{
                myResource.prod();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线成启动");
            System.out.println();
            System.out.println();
            try{
                myResource.consumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("5 seconds over!");
        myResource.stop();
    }
}
class MyResource{
    private volatile boolean flag = true;    //默认开启，进行生产消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName()); //传的是什么
    }
    public void prod() throws Exception{
        String data = null;
        boolean res;
        while (flag){
            data = atomicInteger.incrementAndGet() + "";    //因为此处引用多，所以将data写外面可复用
            res = blockingQueue.offer(data,2,TimeUnit.SECONDS);
            if (res){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 " + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 " + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);        //停这一秒还是挺关键的
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产");
    }
    public void consumer() throws Exception{
        String data = null;
        while (flag){
            data = blockingQueue.poll(2,TimeUnit.SECONDS);
            if (data == null || data.equalsIgnoreCase("")) {
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒钟未取到数据，消费停止");
                flag = false;
            }
            else
                System.out.println(Thread.currentThread().getName() + "\t 弹出队列" + data + "成功");
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产");
    }
    public void stop(){
        this.flag = false;
    }
}
