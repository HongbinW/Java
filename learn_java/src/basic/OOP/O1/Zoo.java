package basic.OOP.O1;
/*
 * 一、面向对象思想
 * 1.设计类，并设计类的成员（成员变量&成员方法）
 * 2.通过类，来创建类的对象（或类的实例化）
 * 3.通过“对象.属性”或“对象.方法”调用，来完成相应的功能
 *
 * 二、创建的多个对象，彼此各自拥有一套类的属性。
 *
 * 三、类的属性（成员变量）
 *    成员变量 vs 局部变量
 *    相同点： 1.遵循变量声明的格式：修饰符  数据类型  变量名 =  初始化值
 *             2.都有作用域
 *    不同点： 1.声明的位置不同：成员变量：声明在类里，方法外
 *                               局部变量：声明在方法内以及方法的形参部分，代码块内
 *             2.成员变量的修饰符有四个：public private protected 缺省
 *               局部变量没有修饰符
 *             3.初始化值：一定会有初始化值
 *                  成员变量：如果在声明的时候，不显式地赋值，那么不同数据类型会有不同的默认初始化值
 *                  局部变量：一定要显式地赋值。（没有默认初始化值）
 *             4.二者在内存中存放的位置不同：成员变量存在堆空间中，局部变量存在栈空间中
 * 四、类的方法：提供某种功能的实现
 *      1)实例：public void eat(){}
 *              public String getName(){}
 *              public void setName(String n){}
 *        格式： 权限修饰符 返回值类型（void：无返回值/具体的返回值，如：String）方法名（形参）{ }
 *      2）关于返回值类型：void：表明此方法不需要返回值
 *                         有返回值的方法：在方法的最后一定有 return + 返回值类型的变量
 *      3）方法内可以调用本类的其它方法和属性，但不能定义新的方法
 *
 */
public class Zoo {
    public static void main(String[] args){
        //基本数据类型的声明：数据类型  变量名 =  初始化值
        int i = 10;
        //类的实例化:如下的a1就是一个实实在在的对象
        Animal a1 = new Animal();
        //int[] arr =new int[10];
        //通过对象调用属性
        a1.name = "旺财";
        a1.age = 3;
        System.out.println("name: " + a1.name + " age: " + a1.age);
        //通过对象调用方法
        a1.eat();
        a1.sleep();

        //在创建一个类的对象
        Animal a2 = new Animal();
        System.out.println("name: " + a2.name + " age: " + a2.age);

        Animal a3 = a1;//a1和a3共用一个对象实体
        System.out.println("name: " + a3.name + " age: " + a3.age);
        a3.name = "维尼熊";
        System.out.println("name: " + a1.name + " age: " + a1.age);

        //int b ;
        //System.out.println(b);
        Animal s = new Animal();
        System.out.println(s.name);//即使没赋值，也会有默认初始化值
    }
}

class Animal{
    //1.属性
    String name;
    int age;

    //2.方法
    public void eat(){
        System.out.println("动物进食");
    }
    public void sleep(){
        System.out.println("动物休眠");
    }

    public String getName(){
        return name;
    }
    public void setName(String n){//n局部变量
        name = n;
    }

}
