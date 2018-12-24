package basic.adclass2;

//单例设计模式
/*
    设计模式：设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式
    23中设计模式。

    单例设计模式：
    1.解决问题：使得一个类只能够创建一个对象。
    2.如何实现？
    //饿汉式//懒汉式
*/

//饿汉式
public class TestSingleton {
    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);   //s1和s2指向的是同一区域
    }
}
//只能创建Singleton的单个实例
class Singleton{
    //1.私有化构造器，使得在类的外部不能够调用此构造器
    private Singleton(){

    }
    //2.在类的内部创建一个类的实例
    private static Singleton instance = new Singleton();
    //3.私有化此对象，通过公共的方法来调用。
    //4.此公共的方法只能通过类来调用，所以设置为static，同时类的实例也必须为static声明的
    public static Singleton getInstance(){
        return instance;
    }
}