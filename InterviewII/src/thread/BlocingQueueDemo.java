package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/8/19 21:58
 * @Version 1.0
 * @Description:
 */
public class BlocingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
//        blockingQueue.put("x");

        blockingQueue.take();
        System.out.println(blockingQueue.peek());

        blockingQueue.take();
        blockingQueue.take();
        System.out.println(blockingQueue.peek());
//        blockingQueue.take();



    }
}
