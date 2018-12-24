package basic.adclass.testDuotai;
//多态使用的一个例子
public class TestAnimal {
    public static void main(String[] args) {
        TestAnimal t = new TestAnimal();
        t.func(new Animal());
        t.func(new Dog());

        t.func(new Cat());

    }
    public void func(Animal a){//Animal a = new Dog();
        a.eat();
        a.jump();

        if(a instanceof Dog){
            Dog d = (Dog)a;
            d.Wang();
        }
        if(a instanceof Cat){
            Cat c = (Cat)a;
            c.catchMouse();
        }
    }
//	public void func(Dog a){
//		a.eat();
//		a.jump();
//	}
}
class Animal{
    String name;
    int age;

    public void eat(){
        System.out.println("进食");
    }
    public void jump(){
        System.out.println("跳");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃食");
    }
    public void jump(){
        System.out.println("狗急跳墙");
    }

    public void Wang(){
        System.out.println("汪汪叫");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void jump(){
        System.out.println("猫跳");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}