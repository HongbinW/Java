package basic.exception;
/*
    一、异常体系结构
    java.lang.Throwable
            ----Error:错误，程序中不进行处理
            ----Exception：异常，要求在编写程序时就要考虑到对这些异常的处理
                    ------编译时异常：在编译期间出现的（javac时出现异常）
                    ------运行时异常：在运行期间出现的（java时出现异常）
    当执行一个程序时，若出现异常，那异常之后的代码就不再执行！
 */
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

public class TestException {
    @Test
    public void test1(){
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        System.out.println(i);
    }
    //常见运行时异常
    //1.数组下表越界的异常:ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int[] i = new int[10];
        System.out.println(i[10]);
    }
    //2.算术异常：ArithmeticException
    @Test
    public void test3(){
        int i = 10;
        System.out.println(i / 0);
    }
    //3.类型转换异常:ClassCastException
    @Test
    public void test4(){
        Object obj = new Date();
        String str = (String)obj;
    }
    //4.空指针异常:NullPointerException
    @Test
    public void test5(){
//        Person p = new Person();
//        p = null;
//        System.out.println(p.toString());
        String str = new String("AA");
        str = null;
        System.out.println(str.length());   //不是0而是空指针
    }

    //编译时异常
    @Test
    public void test6(){
//        FileInputStream fis = new FileInputStream(new File("hello.txt"));
//        int b;
//        while((b = fis.read() = -1)){
//            System.out.println((char)b);
//        }
//        fis.close();
    }
}
class Person{

}
