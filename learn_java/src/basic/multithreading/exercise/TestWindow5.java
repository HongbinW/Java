package basic.multithreading.exercise;

class Window5 implements Runnable {
    int ticket = 100;// 共享数据
    //	Object obj = new Object();
    public void run() {
//		Animal a = new Animal();//局部变量
        while (true) {
            synchronized (this) {//this表示当前对象，本题中即为w
                if (ticket > 0) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "售票，票号为：" + ticket--);
                }
            }
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