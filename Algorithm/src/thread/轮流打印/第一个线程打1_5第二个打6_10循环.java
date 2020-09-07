package thread.轮流打印;

import java.util.concurrent.Semaphore;

/**
 * Description
 * Author  HongbinW
 * Date 2020/9/5
 */
public class 第一个线程打1_5第二个打6_10循环 {
}
class PrintNum{
    public static void main(String[] args){
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(0);
        Thread t1 = new PrintThread(semaphore1, semaphore2);
        t1.setName("Thread1");
        Thread t2 = new PrintThread(semaphore2, semaphore3);
        t2.setName("Thread2");
        Thread t3 = new PrintThread(semaphore3, semaphore1);
        t3.setName("Thread3");
        t1.start();
        t2.start();
        t3.start();
    }
    public static volatile int num = 1;
    public static class PrintThread extends Thread{
        private Semaphore curSem, nextSem;
        public PrintThread(Semaphore curSem, Semaphore nextSem){
            this.curSem = curSem;
            this.nextSem = nextSem;
        }
        public void run(){
            while (true) {
                try {
                    curSem.acquire();
                    for (int i = 0; i < 5; i++) {
                        System.out.printf("%s  %d\n", Thread.currentThread().getName(), num++);
                    }
                    nextSem.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}