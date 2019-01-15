package basic.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    //ArrayList:List的主要实现类
    //List中相对于Collection，新增加的方法
    /**
     * void add(int index,Object ele): 在指定的索引位置index添加元素ele
     * boolean addAll(int index, Collection eles)
     * Object get(int index):获取指定索引的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置，若无返回-1
     * int lastIndexOf(Object obj)：返回obj在集合中最后一次出现的位置，若无返回-1
     * Object remove(int index)：删除指定索引位置的元素
     * Object set(int index, Object ele)：设置（修改）指定索引位置的元素为ele
     * List subList(int formIndex, int toIndex):返回从fromIndex到toIndex(左闭右开)的一个子list
     *
     * List常用的方法：增（add(Object obj)) 删(remove) 改(set(int index, Object obj)) 查(get(int index))
     *                 插（add(int index, Object ele)) 长度（size())
     */


    @Test
    public void testList1(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new String("GG"));
        System.out.println(list);
        list.add(0,555);
        System.out.println(list);
        Object obj = list.get(1);
        System.out.println(obj);
        list.remove(0);
        System.out.println(list.get((0)));
        list.set(0,111);
        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new String("GG"));
        list.add(456);
        System.out.println(list.indexOf(456));      //过程中会调用equals方法
        System.out.println(list.lastIndexOf(456));
        System.out.println(list.indexOf(123) == list.lastIndexOf(123));
        System.out.println(list.indexOf(444));
        List list1 = list.subList(0,3);
        System.out.println(list1);
    }
}
