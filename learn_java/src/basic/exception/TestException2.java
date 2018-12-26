package basic.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    异常处理的方式二：在方法的声明处，显示地抛出该异常对象的类型
    格式：比如：public static void method2() throws FileNotFoundException,IOException
    当在此方法内出现异常的时候，会抛出一个异常类的对象，抛给方法的调用者
    异常的对象可以逐层向上抛，直至try-catch-finally处理

    Java异常处理：抓抛模型
    1.抓：异常的处理，有两种方式（try-catch-finally    throws + 异常类型）
    2.抛：执行过程中，一旦出现异常，就会抛出一个异常类的对象。（自动抛出 vs 手动抛出(throw + 运行时异常对象）
            >手动抛出的异常类可以是现成的异常类，也可以是自己创建的异常类
 */
public class TestException2 {
    public static void main(String[] args) { //再抛就给了虚拟机
        try{
            method2();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void method2() throws FileNotFoundException,IOException{  //一级一级往上抛，给其调用者
        method1();
    }
    public static void method1() throws FileNotFoundException,IOException {    //后者包含前者，可以去掉，甚至可以直接写Exception
        FileInputStream fis = new FileInputStream(new File("hello.txt"));
        int b;
        while ((b = fis.read()) != -1){
            System.out.println((char)b);
        }
        fis.close();
    }

}

