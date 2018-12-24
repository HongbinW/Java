package basic.OOP.O3;

/*
 * package:声明源文件所在的包，写在程序的第一行。
 *   每“.”一次，表示一层文件目录。
 *   包名都要小写。
 *
 * import:
 * 1)显式导入指定包下的类或接口
 * 2)写在包的声明和源文件之间
 * 3)如果需要引入多个类或接口，那么就并列写出
 * 4)如果导入的类是java.lang包下的，如：System String Math等，就不需要显式的声明。
 * 5)理解.*的概念。比如java.util.*;
 * 6)如何处理同名类的导入。如：在util包和sql包下同时存在Date类。显示地使用
 * 7)import static 表示导入指定类的static的属性或方法
 * 8)导入java.lang.*只能导入lang包下的所有类或接口，不能导入lang的子包下的类或接口
 *
 * 常用包
1.java.lang----包含一些Java语言的核心类，如String、Math、Integer、System和Thread，提供常用功能。
2.java.net----包含执行与网络相关的操作的类和接口。
3.java.io   ----包含能提供多种输入/输出功能的类。
4.java.util----包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数。
5.java.text----包含了一些java格式化相关的类
6.java.sql----包含了java进行JDBC数据库编程的相关类/接口
7.java.awt----包含了构成抽象窗口工具集（abstract window toolkits）的多个类，这些类被用来构建和管理应用程序的图形用户界面(GUI)。
8.java.applet----包含applet运行所需的一些类。

 */
//import java.util.Scanner;
//import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.*;
import static java.lang.System.*;
public class TestPackageImport {
    public static void main(String[] args) {
        out.println("helloworld");
        Scanner s = new Scanner(System.in);
        s.next();

        Date d = new Date();
        List list = new ArrayList();

        java.sql.Date d1 = new java.sql.Date(522535114234L);

        Field f = null;
    }
}