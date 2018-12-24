package basic.adclass.testDuotai;
//多态的练习5


/**
 * 建立TestInstance 类，在类中定义方法method1(Person e);
 * 在method1中:
 * (1)根据e的类型调用相应类的getInfo()方法。
 * (2)根据e的类型执行：
 * 如果e为Person类的对象，输出：“a person”;
 * 如果e为Student类的对象，输出
 * “a student”
 * “a person ”
 * 如果e为Graduate类的对象，输出：
 * “a graduated student”
 * “a student”
 * “a person”
 */
public class TestInstance {
    public static void main(String[] args){
        Person1 e = new Person1();
        TestInstance ti = new TestInstance();
        Student s = new Student();
        Graduate g = new Graduate();
        ti.method1(e);
        System.out.println();
        ti.method1(s);
        System.out.println();
        ti.method1(g);

        }
    public void method1(Person1 p){
        System.out.println( p.getInfo());
        if(p instanceof Graduate){
            System.out.println("a graduated student");
        }
        if(p instanceof Student){
            System.out.println("a student");
        }
        if(p instanceof Person1){//满足Student 或者 Graduate 则一定满足Person1
            System.out.println("a person");
        }
    }
}

class Person1 {
    protected String name="person";
    protected int age=50;
    public String getInfo() {
        return "Name: "+ name + "\n" +"age: "+ age;
    }
}
class Student extends Person1 {
    protected String school="pku";
    public String getInfo() {
        return  "Name: "+ name + "\nage: "+ age
                + "\nschool: "+ school;
    }
}
class Graduate extends Student{
    public String major="IT";
    public String getInfo()
    {
        return  "Name: "+ name + "\nage: "+ age
                + "\nschool: "+ school+"\nmajor:"+major;
    }
}
