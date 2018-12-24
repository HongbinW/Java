package basic.adclass2;
/*
    final:最终的，可用来修饰类、属性、方法

    1.final修饰类：这个类就不能被继承，如：String类、StringBuffer类、System类
    2.final修饰方法：这个方法就不能被重写，如：Object类的getClass()方法
    3.final修饰属性：这个属性就是一个常量，一旦初始化后，不可再被赋值习惯上，常量用大写字符表示
        此常量不能使用默认初始化，可以显示地赋值、代码块、构造器（也就是说在定义对象之前都赋值完毕，所以不可通过方法赋值）
      变量用static final修饰：全局常量

      >与finally finalize()区分开来
 */
public class TestFinal {
    public static void main(String[] args){
        Other o = new Other();
        Other p = new Other();
        new TestFinal().addOne(o);
        new TestFinal().addOne(p);
    }
    public void addOne(final Other o){  //参数列表中的final指的是一个引用的地址，所以只要这地址没变，就没出错）
        o.i++;
        System.out.println(o.i);
    }
}
class Other{
    public int i;
}