package M2_Singleton;

/**
 * @Author: HongbinW
 * @Date: 2019/7/14 22:30
 * @Version 1.0
 * @Description:
 */
//饿汉式
public class Singleton {
    private Singleton(){

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
