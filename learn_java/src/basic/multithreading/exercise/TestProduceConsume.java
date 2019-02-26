package basic.multithreading.exercise;

import java.util.Properties;

/**
 * 生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下,如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1.是否涉及到多线程问题？是！生产者消费者
 * 2.共享数据 ？ 有！ 产品数量
 * 3.是否涉及到线程的通信？ 有！ 存在着生产者与消费者的通信
 */

//通过两个类分别实现Runnable接口来产生两个线程，再分别放入Thread的构造器中
//再通过第三个类，并在前两个类中通过构造器实例化，来实现对一个共享数据的控制
class Clerk{
    int product;
    public synchronized void addProduct(){
        if(product > 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            product++;
            System.out.println(Thread.currentThread().getName() + ":生产了第" + product + "产品" );
            notify();
        }
    }
    public synchronized void reduceProduct(){
        if(product <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + ":消费了第" + product + "产品" );
            product--;
            notifyAll();
        }
    }
}
class Produce implements Runnable{
    Clerk clerk;
    public Produce(Clerk clerk){
        this.clerk = clerk;
    }
    public void run(){
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.currentThread().sleep(100
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}
class Consumer implements Runnable{
    Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    public void run(){
        System.out.println("消费者开始消费产品");
        while (true){
            try {
                Thread.currentThread().sleep(10
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.reduceProduct();
        }
    }
}
public class TestProduceConsume {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Produce p1 = new Produce(clerk);
        Consumer c1 = new Consumer(clerk);
        Thread t1 = new Thread(p1);
        Thread t3 = new Thread(p1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
        t3.start();
    }
}
