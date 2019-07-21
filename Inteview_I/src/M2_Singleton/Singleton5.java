package M2_Singleton;

/**
 * @Author: HongbinW
 * @Date: 2019/7/14 22:55
 * @Version 1.0
 * @Description:
 */
//懒汉式
//在内部类被加载和初始化才创建
    //因而是线程安全的
public class Singleton5 {

    private Singleton5(){

    }

    private static class Inner{         //静态内部类不会随外部类的加载和初始化而被初始化，需要单独加载和初始化
        private static Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }
}
