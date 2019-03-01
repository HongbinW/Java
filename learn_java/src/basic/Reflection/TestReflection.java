package basic.Reflection;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflection {

    //在有反射前，如何创建一个类的对象，并调用其中的方法、属性
    @Test
    public void test1() throws  Exception{
        Person p1 = new Person();
        p1.setAge(13);
        p1.setName("ss");
        System.out.println(p1);
        p1.show();
//        p1.display("HK");
    }

    //有了反射，可以通过反射创建一个类的对象，并调用其中的结构
    @Test
    public void test2() throws Exception{
        Class<Person> c = Person.class;

        //1.创建c对应的运行时类Person类的对象
        Person p = c.newInstance();
        //2.通过反射调用运行时类的指定的属性
        //2.1
        Field f1 = c.getField("name");  //其权限必须是public，才能用该方法
        f1.set(p,"LDH");
//        p.setName("LDH");
        System.out.println(p);
        //2.2
        Field f2 = c.getDeclaredField("age");   //IllegalAccessException
        f2.setAccessible(true);                         //这样就可以了
        f2.set(p,20);
        System.out.println(p);
        //3.通过反射调用运行时类的指定的方法
        Method m1 = c.getMethod("show");        //有形参也要把形参写上，因为有方法重载存在的可能性
        m1.invoke(p);//有形参写形参
        Method m2 = c.getMethod("display", String.class); //要求形参要是class类型的，因为原方法时String,所以String.class
        m2.invoke(p,"China");
    }

    /*
        java.lang.Class:是反射的源头
        创建了一个类，通过编译(javac.exe)，生成对应的.class文件，之后我们使用java.exe加载（JVM的类加载器完成）
        此.class文件（每个类对应一个.class文件），该.class文件加载到内存以后就是一个运行时类，存放在缓存区，
        那么这个运行时类本身就是一个Class的实例！
        1.每一个运行时类只加载一次
        2.有了Class的实例以后，我们才可以进行如下的操作：
            1>*创建对应的运行时类的对象
            2>获取对应的运行时类的完整结构（属性、方法、构造器、内部类、父类、所在的包、异常、注解等）
            3>*调用对应的运行时类的指定的结构（属性、方法、构造器）
            4>反射的应用：动态代理
     */
    @Test
    public void test3(){
        Person p = new Person();
        Class clazz = p.getClass();     //通过运行时类的对象，调用其getClass方法，返回其运行时类
        System.out.println(clazz);
    }


    /*
        如何获取Class的实例（三种）
     */
    @Test
    public void test4() throws Exception{
        //1.调用运行时类本身的.class属性
        Class clazz1 = Person.class;
        System.out.println(clazz1.getName());
        Class clazz2 = String.class;
        System.out.println(clazz2.getName());

        //2.通过运行时类的对象获取
        Person p = new Person();
        Class clazz3 = p.getClass();
        System.out.println(clazz3.getName());

        //3.通过Class的静态方法获取(通过此方法体会下反射的动态性)
        String className = "basic.Reflection.Person";   //路径
        Class clazz4 = Class.forName(className);
//        clazz4.newInstance();
        System.out.println(clazz4.getName());

        //4.（了解）通过类的加载器
        ClassLoader cl = this.getClass().getClassLoader();
        Class clazz5 = cl.loadClass(className);
        System.out.println(clazz5.getName());

        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
        System.out.println(clazz1 == clazz5);   //都是true

    }
    //关于类的加载器：ClassLoader

    @Test
    public void test5() throws Exception{
        ClassLoader loader1 = ClassLoader.getSystemClassLoader();   //系统类加载器
        System.out.println(loader1);
        ClassLoader loader2 = loader1.getParent();      //扩展类加载器
        System.out.println(loader2);
        ClassLoader loader3 = loader2.getParent();      //引导类加载器（无法直接获取）
        System.out.println(loader3);
        Class clazz1 = Person.class;        //所以该类使用系统类加载器加载
        ClassLoader loader4 = clazz1.getClassLoader();
        System.out.println(loader4);

        String className = "java.lang.String";      //属于核心库，所以由引导类加载器加载
        Class clazz2 = Class.forName(className);
        ClassLoader loader5 = clazz2.getClassLoader();
        System.out.println(loader5);

        //掌握如下：
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream is = loader.getResourceAsStream("basic\\Reflection\\jdbc.properties");  //通过这种方法可以直接在包下读取文件，而不用在工程下
        Properties pros = new Properties();
        pros.load(is);
        String name = pros.getProperty("user");
        System.out.println(name);
        String password = pros.getProperty("password");
        System.out.println(password);
    }

}
