package basic.multithreading.exercise;
//同步方法
class Window5 implements Runnable {
    int ticket = 100;// 共享数据
    //	Object obj = new Object();
    public void run() {
//		Animal a = new Animal();//局部变量
//        synchronized (this){      //不可写在前面，会造成一个线程进入后，运行完后才会释放，就没其他线程的事了
        while (true) {
            show();
        }
    }
    public synchronized void show(){
            if (ticket > 0) {
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + "售票，票号为：" + ticket--);
            }
    }
}

public class TestWindow5 {
    public static void main(String[] args) {
        Window5 w = new Window5();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}