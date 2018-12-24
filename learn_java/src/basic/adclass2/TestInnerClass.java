package basic.adclass2;
/*
    类的第五个成员：内部类
    1.即在类的内部再定义类，外面的叫外部类，里面的叫内部类
    2.内部类的分类：成员内部类（声明在类内部且方法外），局部内部类（声明在类的方法内）
    3.成员内部类：
        3.1是外部类的一个成员：1>可以有修饰符（4个）（常规来说，类有两个修饰符,public和默认）
                               2>可以用static final修饰
                               3>可以调用外部类的属性和方法
        3.2具有类的特点：1>可以用abstract修饰
                         2>还可以在其内部定义属性、方法、构造器
    4.局部内部类：
        4.1

    关于内部类，掌握三点：1>如何创建成员内部类的对象（如：创建Bird类和Dog类的对象）
                          2>如何区分调用外部类与内部类的变量（尤其是变量重名时）
                          3>局部内部类的使用    //见TestInnerClass1

 */
public class TestInnerClass {
    public static void main(String[] args){
        //创建静态内部类的对象，可以直接通过外部类调用静态内部类的构造器
        Person2.Dog d = new Person2.Dog();
//        Person2.Bird b = new Person2.Bird();
        //创建非静态内部类的对象：必须先创建外部类的对象，通过外部类的对象调用内部类的构造器
        Person2 p = new Person2();
        Person2.Bird b = p.new Bird();  //注意区分
        b.info();
        b.setName("ef");

    }
}
class Person2{
    String name = "ab";
    int age;
    //成员内部类（非static）
    class Bird{
        String name = "cd";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            System.out.println(name);//ef
            System.out.println(this.name);//cd
            System.out.println(Person2.this.name);//ab
        }

        public Bird() {
        }
        public void info(){
            show();
        }
    }
    //成员内部类（静态内部类）
    static class Dog{
        public Dog() {
        }
    }
    public void show(){
        System.out.println("I'm show method");
    }
}