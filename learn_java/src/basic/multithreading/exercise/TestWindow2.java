package basic.multithreading.exercise;
//实现的方式实现window

/**
 * 此程序存在线程的安全问题，打印车票时会出现重票，错票
 */
class windows implements Runnable{
    int ticket = 1;
    public void run(){
        while (ticket <= 100){
            try {
                Thread.currentThread().sleep(10);   //将错误放大
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "所售票号为：" + (ticket++));
        }
    }
}
public class TestWindow2 {
    public static void main(String[] args) {
        windows w = new windows();      //只new了一个对象，创建了三个线程，而这三个线程操作的一个对象，所以ticket不用static
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
