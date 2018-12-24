package basic.adclass;


import basic.adclass.ExperimentDuotai.Test;
import basic.adclass.testDuotai.Person;

public class TestEquals {
    public static void main(String[] args){
//        TestEquals t = new TestEquals();
//        t.test1();

        //equals(): 1>只能处理引用类型变量  2>仍然比较的两个引用变量的地址值是否相等
        //java.lang.Object类，是所有类的根父类
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.equals(p2));  //false

        String str1 = new String("AA");
        String str2 = new String("AA");
        String str3 = "AA";
        System.out.println(str1 == str2);   //false
        System.out.println(str1.equals(str2));  //true
        // 像String类  包装类  File类   Data类  重写了equals()方法，实际比较的是两个实体的内容是否相同

        System.out.println("----------------");
        //关于String类
        String s1 = "AA";   //在栈中定义s1，在方法区的字符串常量池中定义AA
        String s2 = "AA";   //在栈中定义s2，在方法区的字符串常量池中找AA，有则也同样指向，所以s1和s2地址也相同
        String s3 = new String("AA");   //在栈中定义s3，在堆中new出String()，s3指向堆中new出的String()，
                                                 // 而AA依旧在方法区的字符串常量池中，堆中new出的String()有变量指向AA
                                                 //更节省空间
        System.out.println(s1 == s2);       //true
        System.out.println(s1.equals(s2));  //true
        System.out.println(s1 == s3);       //false     //比较的是s1和s3的地址
        System.out.println(s1.equals(s3));  //true      //比较的内容
        //Person p1 = new Person("AA");
        //Person p2 = new Person("AA");
        //System.out.println(p1.name == p2.name);//true   //虽栈中p1,p2所指向的地址不同，但在堆中，
                                                        // 对应的name变量同时指向方法区中的AA，所以地址值相同，所以true

    }
    public void test1(){
        //==
        //1.基本数据类型：根据基本数据类型的值判断是否相等。相等返回true，反之返回false
        //注：两端数据类型可以不同
        //2.引用数据类型：比较引用类型变量的地址值是否相等
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1);
        System.out.println(obj2);
        Object obj3 = obj1;
        System.out.println(obj1 == obj2);//false
        System.out.println(obj3 == obj1);//true
    }
}

