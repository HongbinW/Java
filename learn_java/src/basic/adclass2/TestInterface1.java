package basic.adclass2;
//接口与具体实现类之间也存在多态性
//实现类，有点继承的意思，所以相当于类的多态，实现的接口，就相当于“父类”

//通过接口可以实现不相关类的相同行为，而不需要考虑这些类之间的层次关系
//通过接口可以致命多个类需要实现的方法，一般用于定义对象的拓展功能
//接口主要用来定义规范，解除耦合关系（不用靠继承）
public class TestInterface1 {
    public static void main(String[] args){
        Duck d = new Duck();
        TestInterface1.test1(d);
        TestInterface1.test2(d);
        TestInterface1.test3(d);

    }
    public static void test1(Runner r){    //声明接口，因为接口不能去实例化对象，所以具体操作是由其具体实现类
        r.run();
    }   //Runner r = new Duck();
    public static void test2(Swimmer s ){
        s.swim();
    }//Swimmer r = new Duck();
    public static void test3(Flier f){
        f.fly();
    }//Flier r = new Duck();
}

interface Runner{
    public abstract void run();
}
interface Swimmer{
    void swim();
}
interface Flier{
    void fly();
}

class Duck implements Runner,Swimmer,Flier{
    public void run(){
        System.out.println("run run run");
    }

    @Override
    public void swim() {
        System.out.println("swim swim swim");
    }

    @Override
    public void fly() {
        System.out.println("fly fly fly");
    }
}