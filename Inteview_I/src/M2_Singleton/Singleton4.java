package M2_Singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: HongbinW
 * @Date: 2019/7/14 22:32
 * @Version 1.0
 * @Description:
 */
//静态代码块，依然是饿汉式
    //用于读一些初始化数据
public class Singleton4 {
    private Singleton4(String info){
        this.info = info;
    }
    public static Singleton4 intance;
    private String info;
    static{
        Properties pro = new Properties();
        try {
            pro.load(Singleton4.class.getClassLoader().getResourceAsStream("single.properties"));   //因为single.properties在src即在类路径下，因此可以通过类加载器获得
        } catch (IOException e) {
            throw new RuntimeException();
        }
        intance = new Singleton4(pro.getProperty("info"));
    }
}
