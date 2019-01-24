package basic.changyonglei;

import org.junit.Test;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/23
 */
public class TestString {
    /*
        String：代表不可变的字符序列，底层用char[]存放
        String是final的
     */
    @Test
    public void test1(){
        String str1 = "JavaEE";
        String str2 = "JavaEE";
        String str3 = new String("JavaEE");
        String str4 = "JavaEE" + "Android";
        String str5 = "Android";
        String str6 = str1 + str5;
        str5 = str5 + "Handoop";        //相当于新建了一个字符串"AndroidHandoop"，然后将新的字符串的地址给了str5,所以字符串理解为不可变的字符序列
        String str7 = str6.intern();
        String str8 = "JavaEEAndroid";
        System.out.println(str1 == str2);   //true
        System.out.println(str1 == str3);   //false
        System.out.println(str1.equals(str3));//true

        System.out.println(        );
        System.out.println(str4 == str6);//false
        System.out.println(str4.equals(str6));//true
        System.out.println(str7 == str4);   //true,看的内容
        System.out.println(str4 == str8);   //true

        System.out.println();
        Person p1 = new Person("AA");
        Person p2 = new Person("AA");
        System.out.println(p1.name == p2.name);//true,都是指向字符串常量池的同一个AA
    }
    /**
     * public int length()
     * public char charAt(int index):返回在指定index位置的字符，index从0开始
     * public boolean equals(Object anObject):比较两个字符串内容是否相等，相等为true
     * public int compareTo(String anotherString)：
     * public int indexOf(String s)：返回s字符串在当前字符串中首次出现的位置，若无返回-1
     * public int indexOf(String s ,int startpoint)：返回s字符串从当前字符串startpoint位置开始，首次出现的位置
     * public int lastIndexOf(String s):返回s字符串最后一次在当前字符串出现的位置，若无，返回-1
     * public int lastIndexOf(String s ,int startpoint)：返回s字符串从当前字符串startpoint位置开始，最后一次出现的位置
     * public boolean startsWith(String prefix)：判断当前字符串是否以prefix开始
     * public boolean endsWith(String suffix)：判断当前字符串是否以suffix结束
     * public boolean regionMatches(int firstStart,String other,int otherStart ,int length)
     *  判断当前字符串从firstStart开始的子串与另一个字符串other从otherStart开始，length长，是否equals
     */
    @Test
    public void test2(){
        String str1 = "abcabcadefghijk";
        String str2 = "abca";
        String str3 = "defgh";
        System.out.println(str2.length());
        System.out.println(str1.charAt(10));
        System.out.println();
        System.out.println(str2.equals("abca"));
        System.out.println(str1.compareTo(str2));   //对应位相减
        System.out.println(str1.indexOf(str2));
        System.out.println(str1.lastIndexOf(str2));
        System.out.println(str1.startsWith("abc"));
        System.out.println(str2.endsWith("ca"));
        System.out.println(str1.regionMatches(7,str3,0,str3.length()));
    }

    /**
     * public String substring(int startpoint):从startpoint开始到结尾的子串，start从0开始
     * public String substring(int start,int end)：返回从start开始到end结束的一个左闭右开的子串
     * pubic String replace(char oldChar,char newChar)
     * public String replaceAll(String old,String new)
     * public String trim():去除当前字符串中首尾出现的所有空格（中间不去除）
     * public String concat(String str)：连接当前字符串与str
     * public String[] split(String regex)：按照regex将当前字符串拆分成多个字符串，整个返回值为String[]
     */
    @Test
    public void test3(){
        String str1 = "北京天安门北京";
        String str2 = "上海天安门";
        String str3 = str1.substring(2);
        System.out.println(str3);
        String str4 = str1.replace("北京","燕京");
        System.out.println(str4);   //将所有的都替换掉，而本身不变
        System.out.println(str1);
        String str5 = "   abcd    ef g h   ";
        String str6 = str5.trim();
        System.out.println("----" + str6 + "----");
        System.out.println("----" + str5 + "----");
        String str7 = str1.concat(str2);
        System.out.println(str7);
        String str8 = "abc*d-e7f-ke";
        String[] strs = str8.split("-");
        for(int i = 0; i < strs.length; i++){
            System.out.println(strs[i]);
        }

    }

    //字符串和数组的转化
    /**
     * 1.字符串与基本数据类型、包装类之间的转换
     *  ①字符串 --->基本数据类型、包装类：调用相应的包装类的parseXxx(String str)；
     *  ②基本数据类型、包装类 ---->字符串：调用字符串重载的valueOf()方法
     * 2.字符串与字节数组之间的转换
     *  ①字符串 ----> 字节数组：调用字符串的getBytes()方法
     *  ②字节数组 ----> 字符串：调用字符串的构造器
     * 3.字符串与字符数组的转换
     *  ①字符串 ----> 字符数组：调用字符串的toCharArray()
     *  ②字符数组 ----> 字符串：调用字符串的构造器
     */
    @Test
    public void test4(){
        //1.字符串与基本数据类型、包装类之间的转换
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);
        String str2 = i + "";   //最简单
        str2 = String.valueOf(i);
        System.out.println(str2);
        //2.字符串与字节数组之间的转换
        String str3 = "abcd123";
        byte[] b = str3.getBytes();
        for (int j = 0; j < b.length ; j++) {
            System.out.println((char)b[j]);
        }
        String str4 = new String(b);
        System.out.println(str4);
        //3.字符串与字符数组的转换
        String str5 = "abc123中国人";  //有汉字得用字符，无汉字用字节也可以
        char[] c = str5.toCharArray();
        for (int j = 0; j < c.length; j++) {
            System.out.println(c[j]);
        }
        String str6 = new String(c);
        System.out.println(str6);
    }

}

class Person{
    String name;
    Person(String name){
        this.name = name;
    }
}