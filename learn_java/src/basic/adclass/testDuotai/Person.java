package basic.adclass.testDuotai;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Person {
    private String name;
    private int age;
    public int id = 1001;
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
    public void jump(){
        System.out.println("人跳高");
    }
}
