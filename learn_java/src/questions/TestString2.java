package questions;

/**
 * @Author: HongbinW
 * @Date: 2019/4/3 23:12
 * @Version 1.0
 * @Description:
 */
public class TestString2 {
    public static void func(String str){
        str = "abc";
    }

    public static void main(String[] args) {
        String test = "test";
        func(test);
        System.out.println(test);
    }
}
