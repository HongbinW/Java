package basic.Reflection;

@MyAnnotation(value = "www")
public class Person extends Creature<String> implements Comparable,MyInterface{
    public String name;
    private int age;
    int cd;
    //创建类时，尽量保留一个空参的构造器
    public Person(){
        System.out.println("This is Person's empty constructor");
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age){
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
    @MyAnnotation(value = "abc123")
    public void show(){
        System.out.println("I'm a person");
    }
    private void display(String nation) throws Exception{
        System.out.println("My country is " + nation);
    }
    class Woman{

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public int compareTo(Object o){

        return 0;
    }
}
