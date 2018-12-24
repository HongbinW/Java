package basic.adclass;
/*
    面向对象的特征三：多态性
    1.多态性指的是什么？
    多态性可以理解为一个事物的多种表现形态
        1）方法的重载与重写  2）子类对象的多态性
    2.子类对象的多态性使用的前提：1>要有类的继承 2>要有子类对父类方法的重写
    3.程序分为编译状态和运行状态
        对于多动态性来说，编译时，“看左边”，将此引用变量理解为父类的类型
                          运行时，“看右边”，关注于真正的对象的实体：子类的对象。那么执行的方法就是子类重写的。

    多态性，主要应用于类，当需要传入的参数为父类的实例时，也可以传入子类的，这样可以不用写多个重载
    （见package basic.adclass.testDuotai;中的TestAnimal)

    4.子类对象的多态性并不适用于属性。 因为父类和子类的属性都会加载的内存中。
 */
import basic.adclass.testDuotai.*;
public class Testduotai {
    public static void main(String[] args){
        Person p = new Person();
        p.eat();
        p.walk();

        Man m = new Man();
        m.eat();
        m.walk();
        System.out.println();

        //子类对象的多态性：父类的引用指向子类对象（或者说子类对象的实体赋给父类的引用）
        Person p1 = new Man();  //向上转型
        //虚拟方法调用：通过父类的引用指向子类的对象实体，当调用方法时，实际执行的是子类重写父类的方法。
        p1.eat();
        p1.walk();
        ((Man) p1).dance();
        p1.jump();
        Man m1 = (Man) p1;  //向下转型，使用强转符号：（）
        System.out.println(p1.id);//因为属性没有多态，所以直接按照声明的来
        m1.dance();

        //java.lang.ClassCastException
//        Woman w1 = (Woman) p1;//编译时是Person转Woman，实际Man转Woman，所以会报错
                              //只能子父类之间转换，不能子类之间转换
        System.out.println("------------");
        //比较柔和的方式
        //instanceof：
        //格式：对象a instanceof 类A ： 判断对象a是否是类A的一个实例，是的话返回true，否则返回false
        //若a是A类的实例，那么a也一定是A类的父类的实例
        if(p1 instanceof Woman){
            Woman w2 = (Woman) p1;
            w2.shooping();
        }
        if(p1 instanceof Man){
            Man m2 = (Man) p1;
            m2.dance();
        }
        if(p1 instanceof Person){
            System.out.println("Hello");
        }
    }
}
