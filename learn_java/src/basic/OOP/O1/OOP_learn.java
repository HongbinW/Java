package basic.OOP.O1;
/*
    1.面向对象的编程关注于类的设计
    2.设计类实际上就是设计类的成员
    3.基本的类的成员：属性（成员变量或Field）&方法（Method)

 */
import java.util.Scanner;
public class OOP_learn {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.info();
        p1.name = "ab";
        p1.age = 23;
        p1.sex = true;
        p1.info();

        p1.setName("cd");
        p1.info();

        //实例化Scanner类的对象，通过此对象.nextXxx（）调用，完成相应的功能。
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
    }
}

class Person{
    //1.属性
    String name;
    int age;
    boolean sex;

    //2.方法
    public void eat(){
        System.out.println("人吃饭");
    }
    public void sleep(){
        System.out.println("人睡觉");
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public void info(){
        eat();
        sleep();
        System.out.println("name: " + name + " age " + age + " sex " + sex);
    }
}