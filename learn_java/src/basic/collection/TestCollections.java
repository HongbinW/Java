package basic.collection;

import org.junit.Test;

import java.util.*;

//Collections工具类
/*
    操作Collection和Map的工具类：Collections

 */
public class TestCollections {
    /*List
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(8);
        list.add(13);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list,0,3);
        System.out.println(list);
    }
    /*
    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)
    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
     */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(8);
        list.add(8);
        list.add(8);
        Object obj = Collections.max(list);
        System.out.println(obj);
        int count = Collections.frequency(list,8);
        System.out.println(count);;
        List list1 = new ArrayList();
        list1.add(23);
        list1.add(56);
        list1.add(18);
        list1.add(83);
        Collections.copy(list,list1);   //从0位置覆盖着copy,且要求前者长度大于后者，所以list是有长度的
        System.out.println(list);
        List list2 = Arrays.asList(new Object[list.size()]);
        System.out.println(list2);
        Collections.copy(list2,list);
        System.out.println(list2);

        //通过如下方法保证List的线程安全性
        //Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
        // 从而可以解决多线程并发访问集合时的线程安全问题
        List list3 = Collections.synchronizedList(list);
    }
}
