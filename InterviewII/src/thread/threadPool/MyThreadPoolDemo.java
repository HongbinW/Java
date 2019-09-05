package thread.threadPool;

import java.util.concurrent.*;

/**
 * @Author: HongbinW
 * @Date: 2019/9/2 21:11
 * @Version 1.0
 * @Description:
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try{
            for (int i = 1; i <= 10; i ++){  //maximumPoolSize + 阻塞队列长度。超过了就会抛异常
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
//                TimeUnit.MILLISECONDS.sleep(200); //一个线程即可
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void useThreadPool() {
        //        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
//      ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池一线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N线程

        //10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try{
            for (int i = 1; i <= 10; i ++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
//                TimeUnit.MILLISECONDS.sleep(200); //一个线程即可
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
