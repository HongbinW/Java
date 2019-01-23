package questions;

public class TestString {
    //对比changyonglei.TestString
    public static void main(String[] args){
        String s1 = "hello";                          //s1得到的是字符串常量池中"hello"的地址
        String s2 = new String("hello");    //s2得到的是堆中对应的地址，而堆中对应位置指向字符串常量池中"hello"
                                                     // 实际上是堆中对应位置与s1所指向的位置相同，即地址相同
        String s3 = "hello";
        String s4 = "hell" + "o";
        String s5 = new String("hello");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);   //比较的地址
        System.out.println(s1.equals(s2));  //比较的值
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s2 == s5);
    }
}
