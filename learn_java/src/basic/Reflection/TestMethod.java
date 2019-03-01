package basic.Reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestMethod {
    //1.获取运行时类的方法

    @Test
    public void test1(){
        Class clazz = Person.class;
        //1.getMethods():获取运行时类及其父类中所有的声明为public的方法
        Method[] m1 = clazz.getMethods();
        for(Method m : m1){
            System.out.println(m);
        }
        System.out.println();
        //2.getDeclaredMethods():获取运行时类本身声明的所有方法
        Method[] m2 = clazz.getDeclaredMethods();
        for(Method m : m2){
            System.out.println(m);
        }
    }
    //注解  权限修饰符 返回值类型  方法名  形参列表  异常（抛出来的,try-catch不知道）
    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] m2 = clazz.getDeclaredMethods();
        for(Method m : m2){         //一个方法打印一行，所以其中涉及到的东西都是一个方法内的
            //1.注解
            Annotation[] ann = m.getAnnotations();
            for(Annotation a : ann) {
                System.out.println(a);
            }
            //2.权限修饰符
            String str = Modifier.toString(m.getModifiers());
            System.out.print(str + " ");
            //3.返回值类型
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + " ");
            //4.方法名
            System.out.print(m.getName() + " ");
            //5.形参列表
            System.out.print("(");
            Class[] paramType = m.getParameterTypes();
            for(int i = 0; i < paramType.length; i++){
                System.out.print(paramType[i].getName() + " " + "args-" + i + " ");
            }
            System.out.print(")");
            //6.异常
            Class[] exp = m.getExceptionTypes();
            if(exp.length != 0){
                System.out.print(" throws " );
            }
            for(int i = 0; i < exp.length; i++){
                System.out.print(exp[i].getName() + " ");
            }
            System.out.println();
        }
    }
}
