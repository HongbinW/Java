package basic.adclass2;

/**
 * @Author: HongbinW
 * @Date: 2019/4/5 13:53
 * @Version 1.0
 * @Description: 工厂模式
 */

public class TestFactoryMethod {
    public static void main(String[] args) {
        IworkFactory i  = new Student1();
        i.getwork().dowork();

        IworkFactory i1 = new Teacher();
        i1.getwork().dowork();
    }
}
interface IworkFactory{
    work getwork();
}
interface work{
    void dowork();
}

class Student1 implements IworkFactory{
    public work getwork(){
        return new StudentWork();
    }
}

class Teacher implements IworkFactory{
    public work getwork(){
        return new TeacherWork();
    }
}


class StudentWork implements work{
    public void dowork(){
        System.out.println("Student");
    }
}
class TeacherWork implements work{
    public void dowork(){
        System.out.println("Teacher");
    }
}

