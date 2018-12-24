package basic.OOP.O2;
/*
    一、类的第三个成员：构造器(constructor)
    构造器作用：（1）创建对象（2）初始化对象的属性

    1.设计类时，若不显示声明类的构造器的话，程序会默认提供一个空参的构造器
    2.一旦显示地定义类的构造器，那么默认的构造器就不再提供
    3.如何声明类的构造器。格式：权限修饰符 类名 (){  }
    4.类的多个构造器之间构成重载

    二、类对象的属性赋值的先后顺序：（1）属性的默认初始化（根据类型）
                                    （2）属性的显示的初始化（在类创建属性时）
                                    （3）通过构造器给属性初始化
                                    （4）通过对象.方法的方式给属性赋值
 */
public class TestGZQ {
    public static void main(String[] args){
        Person p = new Person();    //Person()就是构造器
        Person p2 = new Person("ab");
        String str = new String("bilibili");
    }
}
class Person {
    private String name;
    private int age;

    //显示地定义构造器
    //构成了重载
    public Person(String n){
        name = n;
    }
    public Person(){

    }
    public Person(int a){
        age = a;
    }

    public void setAge(int n) {
        age = n;
    }
    public int getAge() {
        return age;
    }

    public void setName(String a) {
        name = a;
    }
    public String getName(){
        return name;
    }

}
