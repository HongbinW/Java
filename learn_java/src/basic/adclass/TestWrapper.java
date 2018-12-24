package basic.adclass;
import org.junit.Test;
/*
    包装类：每种数据类型（共8种）对应着一个类，此类即为包装类
    要求：基本数据类型 包装类 以及String之间的转换
 */
public class TestWrapper {
    //基本数据类型、包装类与String类之间的转换


    @Test
    public void test2(){
        //跟String之间转换，转成谁，就用谁的方法
        //基本数据类型、包装类---->String类：调用String类的静态的重载的valueOf(Xxxx x)方法
        int i1 = 10;
        String str1 = i1 + "";
        Integer i2 = i1;    //自动装箱
        String str4 = i2.toString();    //也可以
        String str2 = String.valueOf(i2);   //自动拆箱
        String str3 = String.valueOf(true); //"true"
        System.out.println(str3);

        //String类---->基本数据类型、包装类：调用包装类的parseXxxx(String str)方法
        int i3 = Integer.parseInt(str2);
        System.out.println(i3);
        boolean b = Boolean.parseBoolean(str3);
        System.out.println(b);
    }


    //基本数据类型与包装类之间的转化
    @Test
    public void test1(){
        int i = 10;
        boolean b = false;
        //基本数据类型---->对应的包装类，调用包装类的构造器
        Integer i1 = new Integer(i);    //将int i升级为包装类i1
        System.out.println(i1.toString());//而之前就不可以，因为基本数据类型，只是一个数不可调用方法，只有对象可以调方法

        Float f = new Float("12.3F");   //可以为字符串，但字符串的实体要跟数据类型相同
        System.out.println(f);

//        i1 = new Integer("12abc");//这样会出现数制转换的异常java.lang.NumberFormatException
//        System.out.println(i1);

        Boolean b1 = new Boolean(true);
        System.out.println(b1);
        b1 = new Boolean("true1abc");   //形参时true结果才是true，否则都是false，而不会像之前报异常
        System.out.println(b1);

        Order o = new Order();
        System.out.println("$" + o.b);  //因为b的类型是Boolean，是一个包装类为引用数据类型，所以为$null
                                        //如果b的类型是boolean，则结果为$false

        //包装类----->基本数据类型：调用包装类的Xxx的xxxValue()方法
        int i2 = i1.intValue();
        System.out.println(i2);
        float f1 = f.floatValue();
        System.out.println(f1);
        boolean b2 = b1.booleanValue();

        //JDK5.0以后，自动装箱和拆箱
        int i4 = 12;
        Integer i3 = i4;    //自动装箱
        Boolean bb = false;
        int i5 = i3;        //自动拆箱

    }
}
class Order{
    Boolean b;
}