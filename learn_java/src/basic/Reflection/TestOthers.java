package basic.Reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestOthers {
    //1.获取运行时类的父类
    @Test
    public void test1(){
        Class clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);
    }

    //2.获取带泛型的父类
    @Test
    public void test2(){
        Class clazz = Person.class;
        Type type1 = clazz.getGenericSuperclass();
        System.out.println(type1);
    }

    //3*.获取父类的泛型
    @Test
    public void test3(){
        Class clazz = Person.class;
        Type type1 = clazz.getGenericSuperclass();
        ParameterizedType param = (ParameterizedType)type1;
        Type[] t = param.getActualTypeArguments();
        System.out.println(((Class)t[0]).getName());
    }

    //4.获取实现的接口
    public void test4(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
    }

    //5.获取所在的包
    @Test
    public void test5(){
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    //6.获取注解
    @Test
    public void test6(){
        Class clazz = Person.class;
        Annotation[] anno = clazz.getAnnotations();
        for(Annotation a : anno){
            System.out.println(a);
        }
    }

}
