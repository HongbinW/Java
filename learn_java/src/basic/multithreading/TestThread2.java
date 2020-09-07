package basic.multithreading;
/*
    //创建多线程的方式二：通过实现的方式

    对比创建多线程的两种方式：
    1.联系：public class Thread implements Runnable
    2.哪个方式好？实现的方式优于继承的方式
        ①避免了单继承的局限性
        ②更适合多个线程操作一份资源
 */
//1.创建一个实现了Runnable接口的一个类
class PrintNum implements Runnable{
    //  new:如果int i = 0;则多个线程操作这一个i
//    int i = 0;
    //2.实现接口的抽象方法
    public void run(){
        for(int i = 0; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class TestThread2 {
    public static void main(String[] args) {
        //3.创建一个Runnable接口实现类的对象
        PrintNum pn = new PrintNum();
        //要想启动一个多线程，必须调用start方法
        //4.将此对象作为形参传递给Thread类的构造器中，创建Thread类的对象，此对象即为一个线程
        Thread t1 = new Thread(pn); //让该类与Thread类发生点关系,利用Thread的构造器
        //5.调用start()方法，启动线程
        t1.start();     //启动线程，执行Thread对象生成时构造器形参的对象的run()方法

        //再创建一个线程
        Thread t2 = new Thread(pn);
        t2.start();
    }
}
