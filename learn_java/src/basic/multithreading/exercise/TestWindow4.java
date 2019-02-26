package basic.multithreading.exercise;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张
//继承的方式
//存在线程安全问题--->使用同步代码块处理
class Window4 extends Thread {
    static int ticket = 1;
    static Object obj = new Object();   //必须加static，否则还是各自用各自的锁

    public void run() {
//        synchronized (obj) {       //this表示：w1,w2,w3，用的不是一把锁，所以不能用this
            while (true) {
//            show();
                synchronized (obj){
                if (ticket <= 100) {
                    try {
                        Thread.currentThread().sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "所售票号为：" + (ticket++));
                }
//                else {
//                    break;
//                }
            }
        }
    }
//    public synchronized void show(){        //还是因为this，三个对象三把锁，所以这样是错的
//        if (ticket <= 100) {
//            try {
//                Thread.currentThread().sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "所售票号为：" + (ticket++));
//        }
//    }
}

public class TestWindow4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
