import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test{
    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(()->{
            for (int i = 0; i < 3; i ++){
                mySource.print5();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 3; i ++){
                mySource.print10();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 3; i ++){
                mySource.print15();
            }
        },"CC").start();
    }
}
class MySource{
    volatile int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            for (int i = 0; i < 1; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                number ++;
            }
            condition2.signal();
            condition1.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            for (int i = 0; i < 2; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                number ++;
            }
            condition3.signal();
            condition2.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            for (int i = 0; i < 3; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                number ++;
            }
            condition1.signal();
            condition3.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print(){
        while (Thread.currentThread().getName().equals("AA")){
            for (int i = 0; i < 1; i ++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                number ++;
            }
        }

    }
}