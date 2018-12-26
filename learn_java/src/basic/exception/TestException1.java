package basic.exception;

import org.junit.Test;
import java.util.Arrays;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
    二、如何处理Exception异常
    抓抛模型：
    1.“抛”：当我们执行代码时，一旦出现异常，就会在异常的代码处生成一个对应的类型的对象，
              并将此对象抛出。（自动抛出、手动抛出）
              >一旦抛出此异常类的对象，程序就终止执行
              >此异常类的对象抛给方法的调用者
    2.“抓”：抓住上一步抛出来的异常类的对象。如何抓？即为异常处理的方式
              java提供了两种方式用来处理一个异常类的对象
              处理方式一：
              try{
                //可能出现异常的代码
              }catch(Exception e1){
                //处理的方式1
              }catch(Exception e2){ //类似else if
                //处理的方式2
              }finally{
                //一定要执行的代码
              }
    注：1.try内声明的变量，类似于局部变量，出了try{}语句，就不能被调用
        2.catch{} finally{}可以没有
        3.catch语句内部是对异常对象的处理
            >getMessage();       printStackTrace;       自定义处理
        4.可以有多个catch语句，try中抛出的异常类对象从上往下去匹配catch中的异常类的类型，一旦满足
          就执行catch中的代码，执行完，就跳出其后的多条catch语句
        5.如果异常处理了，其后代码继续执行
        6.若catch中多个异常类型是“并列”关系，谁上谁下都行
          若catch中是包含关系，则范围小的写上面
        7.finally中存放的是一定会被执行的代码，即使catch中仍有异常或有return语句（见TestFinally）
          finally一定会运行是指在程序跳出前，一定会运行
        8.try-catch是可以相互嵌套的
    三、对于运行时异常来说，可以不显示地处理，但对于编译时异常来说，必须显示地处理

 */
public class TestException1 {
    @Test
    public void test1(){
        Scanner s = new Scanner(System.in);
        try {
            int i = s.nextInt();
            System.out.println(i);
        }catch (InputMismatchException e){
            System.out.println("出现类型不匹配的异常");
        }
    }
    //常见运行时异常
    //1.数组下表越界的异常:ArrayIndexOutOfBoundsException
    @Test
    public void test2() {
        try {
            int[] i = new int[10];
            System.out.println(i[10]);
        } catch (Exception e) {   //实际应该是ArrayIndexOutOfBoundsException，此处类似于多态，写的是他的父类
            System.out.println("出现异常");
        }
    }
    //2.算术异常：ArithmeticException
    @Test
    public void test3(){
        try {
            int i = 10;
            System.out.println(i / 0);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    //3.类型转换异常:ClassCastException
    @Test
    public void test4(){
        try {
            Object obj = new Date();
            String str = (String)obj;
        }catch (ClassCastException e){
            System.out.println("出现类型转换异常");
//            System.out.println(10/0);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("hello world");  //catch中又出现异常了，若写在外面，仍旧不会执行，而写在finally里面是可以执行的

        }
        System.out.println("hello");
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
//        try {
//            FileInputStream fis = new FileInputStream(new File("hello.txt"));
//            int b;
//            while ((b = fis.read() = -1)) {
//                System.out.println((char) b);
//            }
//
//
//        }catch (FileNotFoundException e1){
//            System.out.println("文件不存在");
//        }catch (IOException e1){
//            System.out.println(e1.getMessage());
//        }
//                finally{
//                    fis.close;
//        }

        }
    }
class Person1{

}


