package basic.adclass2;
/*
    接口（Interface）   是与类并行的一个概念
    1.接口可以看做是一个特殊的抽象类。是常量与抽象方法的一个集合，不能包含变量以及一般的方法(JavaSE8之后可以实现简单的方法）。
    2.接口是没有构造器的。
    3.接口定义的就是一种功能，此功能可以被类所实现（implements）。
    比如：class  CC extends DD implements AA
    4.实现接口的类，必须要重写原接口中所有的抽象方法，方可实例化，若未重写所有的抽象方法，则此类仍为一个抽象类
    5.类可以实现多个接口。-----java中类的继承是单继承的
    6.接口与接口之间也是继承的关系，接口的继承是多继承的
    >5,6，描述的是Java继承的特点

 */
public class TestInterface {
    public static void main(String[] args){
        System.out.println(AA.I);
//        AA.I = 13;

    }
}

interface AA{

    //常量:所有的常量都用 pulic static final修饰
    int I = 12; //常量的声明方式
    boolean FLAG = false;
    //抽象方法：所有的都用public abstract修饰
    void method1();
    void method2();
    //所以常量和抽象方法前，都省略了对应的修饰部分
}
abstract class BB implements AA{

}
class DD{

}
interface MM{
    void method3();
}

class  CC extends DD implements AA,MM{ //
    public void method1(){  //因为接口中有默认的pulic，所以此处必须加上public，否则会认为是default

    }
    public void method2(){

    }
    public void method3(){

    }
}
interface JJ extends MM,AA{
    void method4();
}