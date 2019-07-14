package basic.adclass;

import org.junit.Test;

/**
 * Junit单元测试类
 * 1.File-Project Structure-modules-dependencies-增加jar or directories，去IDEA根目录下lib找到相应的包
 * （选择的是junit-4.12.jar，因版本问题，还需要导入hamcrest-core-1.3.jar，才可使用）
 * 2.在主类中，创建一个空参的无返回值的方法，(如：public void test1())用于代码测试，方法上声明：@Test1
 * 3.导入import org.junit.Test1;
 * 4.在test1()方法中，进行代码的编写
 * 5.测试：选中方法名，邮件run test1即可
 */

public class TestJunit {
    public static void main(String[] args){
        String str = "AA";
        System.out.println(str);
    }
    @Test     //版本问题，实际效果是相当于main方法，也就是说，在这个类中，可以执行任意代码
    public void test1(){    //要紧贴@Test1，不能空行
        String str = "AA";
        System.out.println(str);
    }
}
