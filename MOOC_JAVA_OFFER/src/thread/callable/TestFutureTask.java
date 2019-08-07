package thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: HongbinW
 * @Date: 2019/8/3 14:24
 * @Version 1.0
 * @Description:
 */
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new TestCallable());   //构造函数可以接收Callable
        new Thread(task).start();       //FutureTast两层实现到Runnable，因此此处也可以放到Thread构造器
        if (!task.isDone()){    //检测拿到的Callable的call方法是否执行完成
            System.out.println("task has not finished,please wait!");
        }
        System.out.println("task return : " + task.get());  //task.get()阻塞当前线程，直到Collable的call方法执行完毕，取到返回值才返回（精准获取子线程处理后的返回值）。
        // 拓展：get()方法还可以传入一个时间，作为超时机制，如果超时则抛出异常

    }
}
