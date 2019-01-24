package basic.changyonglei;

import org.junit.Test;

/*
    java.lang.StringBuffer：代表可变的字符序列，可以对字符串进行增删
    java.lang.StringBuilder：可变的字符序列，JDK1.5后加入的，线程不安全，效率要高于StringBuffer
 */
public class TestStringBuffer {
    @Test
    public void test1(){
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());
        sb.append("abc").append("123");
        StringBuffer sb1 = new StringBuffer("abc123");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("abc123");
        StringBuffer sb3 = new StringBuffer("abc123");
        System.out.println(sb == sb1);  //false
        System.out.println(sb1 == sb2); //false
        System.out.println(sb1 == sb3); //false     创建时候已经有地址了，后面再加东西也不会变
    }

    /**
     * StringBuffer append(String s),   StringBuffer append(int n) ,
     * StringBuffer append(Object o) ,  StringBuffer append(char n),
     * StringBuffer append(long n),  StringBuffer append(boolean n),
     * StringBuffer insert(int index, String str)
     * public StringBuffer reverse：反转此StringBuffer，自身也反转
     * StringBuffer delete(int startIndex, int endIndex)
     * public char charAt(int n )
     * public void setCharAt(int n ,char ch)
     * StringBuffer replace( int startIndex ,int endIndex, String str)
     * public int indexOf(String str)
     * public String substring(int start,int end)
     * public int length()
     *
     * 总结：添加：append()
     *       删除：delete(int startIndex, int endIndex)
     *       插入：insert(int index, String str)
     *       修改：setCharAt(int n,char ch)
     *       查：charAt(int n)
     *       反转：reverse()
     *       长度：length()
     *
     */
    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abc123");
        sb1.insert(3,"def");
        System.out.println(sb1);
        StringBuffer sb2 =  sb1.reverse();
        System.out.println(sb1);        //本身也变了
        System.out.println(sb2);

    }
    /**
     * 对比String,StingBuffer,StringBuilder三者的在添加上的效率
     * 效率从高到低：StringBuilder > StringBuffer > String
     */
    @Test
    public void test3(){
        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for(int i = 0;i<20000;i++){
            buffer.append(String.valueOf(i));}
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0;i<20000;i++){
            builder.append(String.valueOf(i));}
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0;i<20000;i++){
            text = text + i;}
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间："+(endTime-startTime));
    }
}
