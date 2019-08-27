package thread.produceAndConsumer;

/**
 * @Author: HongbinW
 * @Date: 2019/8/27 21:03
 * @Version 1.0
 * @Description:
 */
public class synchronizedWaitNotify {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++) {
                sharedResource.increase();
            }
        },"AA").start();
        new Thread(()->{
            for(int i = 0 ; i < 10; i ++)
                sharedResource.decrease();
        },"BB").start();
    }
}
class SharedResource{
    private int number = 0;

    public void increase(){
        synchronized (this) {
            while (number != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            notify();
        }
    }

    public void decrease() {
        synchronized (this) {
            while (number == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            notify();
        }
    }
}