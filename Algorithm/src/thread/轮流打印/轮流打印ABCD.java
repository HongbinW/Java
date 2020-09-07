package thread.轮流打印;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/14
 */
public class 轮流打印ABCD {
}

// 思路，通过信号量来控制，每次当前线程信号-1，下一个信号+1，即可操作
class PrintABC {
    public static int MAX_TIME = 10;

    public static class PrintThread extends Thread {
        private String printChar;
        private Semaphore curSemaphore, nextSemaphore;

        public PrintThread(String printChar, Semaphore curSemaphore,
                           Semaphore nextSemaphore) {
            this.printChar = printChar;
            this.curSemaphore = curSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        public void run() {
            for (int i = 0; i < MAX_TIME; ++i) {
                try {
                    curSemaphore.acquire();  /* 请求打印需要的信号量，资源数-1，即down操作  */
                    System.out.println(printChar);
                    nextSemaphore.release(); /* 释放下一个线程打印需要的信号量，资源数+1，即up操作  */
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        Semaphore semaphoreA = new Semaphore(1); /* 只有A信号量的初始资源数为1，保证从A开始打印  */
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        Semaphore semaphoreD = new Semaphore(0);

        new PrintThread("A", semaphoreA, semaphoreB).start();
        new PrintThread("B", semaphoreB, semaphoreC).start();
        new PrintThread("C", semaphoreC, semaphoreD).start();
        new PrintThread("D", semaphoreD, semaphoreA).start();
    }
}