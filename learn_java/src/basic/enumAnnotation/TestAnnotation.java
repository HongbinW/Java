package basic.enumAnnotation;

import java.util.ArrayList;
import java.util.List;

//注解
/*
    1.三个基本的Annotation
    @Override: 限定重写父类方法, 该注释只能用于方法
    @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
    @SuppressWarnings: 抑制编译器警告
    2.如何自定义注解
    3.元注解,修饰注解的注解
 */
public class TestAnnotation {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();
        p.eat();


    }
}
@MyAnnotation()
class Student extends Person{
    @Override
    public void walk(){
        System.out.println("Student walk");
    }
    @Override
    public void eat(){
        System.out.println("Student eat");
    }
}
@Deprecated
class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void walk(){
        System.out.println("walk");
    }
    @Deprecated                 //虽然过时，但目前依然能用，过渡期起提示作用
    public void eat(){
        System.out.println("eat");
    }
}