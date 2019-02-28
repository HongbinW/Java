package basic.Reflection;

public class Person {
    public String name;
    private int age;
    //创建类时，尽量保留一个空参的构造器
    public Person(){
        System.out.println("This is Person's empty constructor");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("I'm a person");
    }
    public void display(String nation){
        System.out.println("My country is " + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
