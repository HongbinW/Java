package M2_Singleton;

/**
 * @Author: HongbinW
 * @Date: 2019/7/14 22:30
 * @Version 1.0
 * @Description:
 */
//懒汉式
public class Singleton2 {
    private Singleton2(){

    }

    private static Singleton2 intance = null;

    public static Singleton2 getInstance(){
        if(intance == null) {               //进一步提高性能
            synchronized (Singleton2.class) {   //满足安全性问题
                if (intance == null){
                    intance = new Singleton2();
                }
            }
        }
        return intance;
    }
}
