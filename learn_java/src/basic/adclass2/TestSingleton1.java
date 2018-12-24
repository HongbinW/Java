package basic.adclass2;
//懒汉式：可能存在线程安全问题
public class TestSingleton1 {
    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);   //s1和s2指向的是同一区域
    }
}
class Singleton1{
    //1.
    private Singleton1(){

    }
    //2.
    private static Singleton1 instace = null;
    //3.
    public static Singleton1 getInstace(){
        if(instace == null)
            instace = new Singleton1(); //用的时候再创建
        return instace;
    }
}