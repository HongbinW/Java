package basic.adclass.testSuper;
/*
    子类对象实例化的全过程
 */
public class TestDog{
    public static void main(String[] args){
        Dog d = new Dog();
        d.setAge(10);
//        d.setName("旺财");
        d.setHostName("小明");

        System.out.println("name: " + d.getName() + " age: " + d.getAge() + " hostName: " + d.getHostName());
    }

}

class Creator{
    private int age;

    public Creator() {
        System.out.println("This is a Creator's constructor");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Animal extends Creator{
    private String name;

    public Animal() {
//        super();
        this("cd");
        System.out.println("This is a Animal's constructor");
    }
    public Animal(String n){
        super();
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal{
    private String hostName;

    public Dog() {
        super("cd");
        this.hostName = "ab";
        System.out.println("This is a Dog's constructor");
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}