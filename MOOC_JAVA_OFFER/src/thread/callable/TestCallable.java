package thread.callable;

import java.util.concurrent.Callable;

/**
 * @Author: HongbinW
 * @Date: 2019/8/3 14:22
 * @Version 1.0
 * @Description:
 */
public class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception{
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
