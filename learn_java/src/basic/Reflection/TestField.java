package basic.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestField {
    //获取对应的运行时类的属性
    @Test
    public void test1(){
        Class clazz = Person.class;
        //1.getFields()只能获取到运行时类及其父类中声明为public的属性
        Field[] f = clazz.getFields();
        for(int i = 0; i < f.length; i++){
            System.out.println(f[i]);
        }

        //2.getDeclaredFields():获取运行时类本身声明的所有的属性
        Field[] f1 = clazz.getDeclaredFields();
        for(Field field:f1){
            System.out.println(field.getName());
        }
    }
    //权限修饰符  变量类型   变量名
    //获取属性的各个部分的内容
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] f1 = clazz.getDeclaredFields();
        for(Field field:f1){
            //1.获取每个属性的权限修饰符
            int i = field.getModifiers();
            String str = Modifier.toString(i);
            System.out.print(str + "\t");
            //2.获取每个属性的变量类型
            Class type = field.getType();
            System.out.print(type.getName() + " ");
            //3.获取每个属性的变量名
            System.out.println(field.getName());
        }
    }
}
