package basic.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestConstructor {
    @Test
    public void test1() throws Exception{
        String classname = "basic.Reflection.Person";
        Class clazz1 = Class.forName(classname);
        //1.创建对应的运行时类的对象，使用newInstance()，实际上就是调用了运行时类的空参构造器
        //要求：①对应的运行时类，必须要有一个空参构造器 ②权限修饰符一定要够
        Object obj = clazz1.newInstance();
        Person p = (Person)obj;
        System.out.println(p);
    }

    @Test
    public void test2() throws Exception{
        String classname = "basic.Reflection.Person";
        Class clazz = Class.forName(classname);
        Constructor[] cons = clazz.getDeclaredConstructors();
        for(Constructor c : cons){
            System.out.println(c);
        }

    }
}
