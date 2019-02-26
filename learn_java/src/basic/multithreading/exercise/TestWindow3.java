package basic.multithreading.exercise;

class windows3 implements Runnable{
    int ticket = 1;     //共享数据
    Object obj = new Object();//应用成员变量，所有线程共用一个锁
    public void run() {
//        Object obj = new Object();//局部变量，导致各自锁自己的
        synchronized (obj){     //任意类的对象，此处也可以换成this，表示当前对象，即本例中的w，也只建了一个
        while (ticket <= 100) {
            try {
                Thread.currentThread().sleep(10);   //将错误放大
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "所售票号为：" + (ticket++));
        }
    }
    }
}
public class TestWindow3 {
    public static void main(String[] args) {
        windows3 w = new windows3();      //只new了一个对象，创建了三个线程，而这三个线程操作的一个对象，所以ticket不用static
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
