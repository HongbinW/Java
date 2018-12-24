package basic.adclass2;
//抽象类，是用来模型化那些父类无法确定全部实现，而是由其子类提供具体实现的对象的类
/*
    abstract：抽象的，可以用来修饰类、方法

    1.abstract修饰类，抽象类
    1>不可被实例化
    2>抽象类有构造器（为了子类的调用）（凡是类都有构造器）
    3>抽象方法所在的类一定是抽象类（因为如果不是抽象类，则可以实例化，而抽象方法是没有方法体的）
    4>抽象类中可以没有抽象方法

    2.abstract修饰方法，抽象方法
    1>格式：没有方法体，包括{}。如：public abstract void eat();
    2>抽象方法只保留方法的功能，具体的执行，交给继承抽象类的子类，由子类来实现（重写）
    3>若子类继承了抽象类，并重写了所有的抽象方法，则此类可正常实例化
    4>若子类继承了抽象类，并没有重写所有的抽象方法，意味着此类中继承了抽象类中的抽象方法，则此类必须声明为抽象的

 */
public class TestAbstractClass {
    public static void main(String[] args){
//        Person p1 = new Person();
//        p1.eat();
        Student s = new Student();
        s.eat();
//        Person p = new Worker();    //多态，若直接删掉person中的eat方法，则编译时会出错
//        p.eat();
    }
}


abstract class Person{
    String name;
    public Person(){

    }
    public Person(String name){
        this.name = name;
    }
    public abstract void eat();     //因为是抽象类，所以不能去实例化，那他的方法也只是为了让子类重写，
                                    // 所以可以删掉其方法体，然后abstract，具体实现由子类实现
    public abstract void walk();
}
class Student extends Person{
    public void eat(){
        System.out.println("Student eat");
    }
    public void walk(){
        System.out.println("Student walk");
    }
}
abstract class Worker extends Person{    //注释掉了其中一个方法，则这个类依然继承了抽象方法，所以也要改成抽象类
    public void eat(){
        System.out.println("Worker eat");
    }
    public void walk(){
        System.out.println("Worker walk");
    }
}
