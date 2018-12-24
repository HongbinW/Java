package basic.OOP.O3;
/*
    this：
    1.可以用来修饰属性、方法、构造器，通常用于形参与成员变量重名，不重名this省略
    2.this理解为当前对象或当前正在创建的对象。比如this.name,this.show()；
    3.可以在构造器中通过"this(形参)"的方式显示地调用本类中其他重载的指定的构造器。
      要求：1.在构造器内部必须声明在首行！
            2.若一个类中有N个构造器，则最多有N-1个构造器使用了this(形参)
 */

public class TestThis {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.setAge(10);
        p1.info();
        p1.setName("ab");
        p1.info();
        System.out.println();
        Person p2 = new Person("abc",23);
    }
}

class Person{
    private String name;
    private int age;

    public Person(){
    }
    public Person(String name){
        System.out.println("这是Person类中形参为name的构造器");
        this.name = name;
    }
    public Person(int age){
        this();

        this.age = age;
    }
    public Person(String name,int age){
        //this():可以用来显示地调用当前类的重载的指定的构造器
        this(name);//调用其他构造器必须放在首行
        //this(age);两个构造器来回调用，死循环
        this.age = age;
    }
    //this.name表示当前正在创建的对象，name表示为形参
    public void setName(String name){   //重名
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int a){
        age = a;
    }
    public int getAge(){
        return age;
    }
    public void eat(){
        System.out.println("人吃饭");
    }
    public void sleep(){
        System.out.println("人睡觉");
    }
    public void info(){
        System.out.println("name: " + this.name);
        System.out.println("age: " + age);
        this.show();    //当前对象
    }
    public void show(){
        System.out.println("I'm a person.");
    }
}
