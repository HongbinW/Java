package thread;

/**
 * @Author: HongbinW
 * @Date: 2019/8/3 13:39
 * @Version 1.0
 * @Description:
 */
public class TestRunAndStart {
    private static void attack(){
        System.out.println("Fight");
        System.out.println("The current thread name is : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                attack();
            }
        };
        System.out.println("The current thread name is : " + Thread.currentThread().getName());
//        t.run();
        t.start();
    }
}
