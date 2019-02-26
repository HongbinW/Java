package basic.multithreading;
/*
    用一条线能串起来是单线程，称为主线程。否则多线程

    创建一个子线程，完成1-100之间自然数的输出，同样地主线程执行同样的操作
    创建多线程的第一种方式：继承Thread类

 */
//1.创建一个继承于Thread的子类
class SubThread extends Thread{
    //2.重写Thread类的run()方法，方法内实现此子线程要完成的功能
    public void run(){
        for(int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
        //3.创建一个子类的对象
        SubThread st1 = new SubThread();
        SubThread st2 = new SubThread();
        //4.调用线程的start()：启动此线程；调用相应的run()方法
        //一个线程只能执行一次start()
        st1.start();
        st2.start();
//        st.run();   //全是main，所以是单线程的
        for(int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

