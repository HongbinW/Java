package basic.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class TestIterator {
    //正确的方法 ，使用迭代器Iterator实现集合遍历
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);  //123是对应的包装类
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        coll.add(new Peroson("MM",23));

        Iterator i = coll.iterator();   //相当于i开始指向0号元素前一个元素,直至指向最后一个元素，停止
        while(i.hasNext()){             //判断下一个是否有值
            System.out.println(i.next());//有值，则向下移动一个，并打印
        }
    }
    //错误的写法
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);  //123是对应的包装类
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        coll.add(new Peroson("MM",23));

        Iterator i = coll.iterator();
        while(i.next() != null){                   //隔行打印
            //最后会出现 java.util.NosuchElementException
            System.out.println(i.next());
        }
    }
    //增强for循环来实现集合的遍历
    @Test
    public void testFor(){
        Collection coll = new ArrayList();
        coll.add(123);  //123是对应的包装类
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        coll.add(new Peroson("MM",23));

        for(Object i:coll){
            System.out.println(i);
        }
    }
    //使用增强for循环实现数组的遍历
    @Test
    public void testFor1(){
        String[] str = new String[]{"AA","BB","CC"};
        for(String i:str){
            System.out.println(i);
        }
    }
    //**********************************************************
    //面试题：
    @Test
    public void testFor2(){
        String[] str = new String[]{"AA","BB","CC"};
        for(int i = 0;i < str.length;i++){
            str[i] = i + " ";
        }
        for(int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }

    }
    @Test
    public void testFor3(){
        String[] str = new String[]{"AA","BB","CC"};
        for(String s : str){
            s = "MM";
            System.out.println(s);  //s是个局部变量，开始将str的值给s，之后s又赋值为MM，因此是三个MM，
                                    //而原str不变，因此重新遍历，依然是原来的元素
        }
        for(int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }
    }
}
