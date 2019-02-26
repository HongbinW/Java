package basic.multithreading.exercise;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张
//存在线程安全问题
class Win extends Thread{
    static int ticket = 1;
    public void run(){
        while(ticket <= 100)
            System.out.println(Thread.currentThread().getName() + "所售票号为：" + (ticket ++));
    }
}
public class TestWindow {
    public static void main(String[] args) {
        Win w1 = new Win();
        Win w2 = new Win();
        Win w3 = new Win();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
