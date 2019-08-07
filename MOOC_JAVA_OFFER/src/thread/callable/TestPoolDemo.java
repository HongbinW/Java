package thread.callable;

import java.util.concurrent.*;

/**
 * @Author: HongbinW
 * @Date: 2019/8/3 14:35
 * @Version 1.0
 * @Description:
 */
public class TestPoolDemo {
    public static void main(String[] args){
        //创建线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //提交任务
        Future<String> future = newCachedThreadPool.submit(new TestCallable());
        if (!future.isDone()){
            System.out.println("task has not finished,please wait!");
        }
        try {
            System.out.println("task return : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown(); //使用线程池一定要关闭！
        }
    }
}
