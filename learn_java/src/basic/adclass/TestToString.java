package basic.adclass;
/**
 * toString()方法：
 * java.lang.Object类的toString()方法的定义如下：
 * public String toString(){
 *     return getClass().getName() + "@" + Integer.toHexString(hashCode())；
 * }
 * 1.当我们打印一个对象的引用时，实际上默认调用的就是这个对象的toString()方法
 * 2.当我们打印的对象所在的类没有重写Object中的toString()方法时，那么调用的就是Object中的toString()方法
 *   返回此对象所在的类及对应的堆空间对象实体的首地址值
 * 3.通常这样来重写，将对象的属性的信息返回
 * 4.像String类、包装类、File类、Date类等，已经实现了Object类中的toString()方法的重写，返回的是实体内容
 *
 */

import basic.adclass.testDuotai.*;
public class TestToString {
    public static void main(String[] args){
        Person p1 = new Person("AA",10);
        System.out.println(p1.toString());
        System.out.println(p1); //basic.adclass.testDuotai.Person@4554617c


    }
}
