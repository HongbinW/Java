package basic.collection;

import basic.adclass.testDuotai.Person;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

/*
    Collection接口
                ----Set：元素无序，不可重复的集合（类似集合）Set中常用的方法都是Collection中定义的
                        ----HashSet(主要实现类)
                        ----LinkedHashSet
                        ----TreeSet
                ----List:元素有序，可重复的集合（“动态”数组）
                        ----ArrayList（主要的实现类）
                        ----LinkedList(链表实现，用于频繁的插入删除操作)
                        ----Vector(古老的实现类、线程安全的)
 */
public class TestSet {
    /*
        Set:存储的元素是无序的，不可重复的
        1.无序性，无序性不等于随机性.无序性指的是元素在低层存储的位置是无序的
        2.不可重复性：向Set中添加进相同元素（内容）时，后面的不能添加进去(size()是不变的）
        说明：要求添加进Set中的元素所在的类，一定要重写equals()和hashCode()方法,进而保证Set的不可重复性

        Set中元素是如何存储的呢？采用的是哈希算法。
        当向Set中添加对象时，首先调用此对象所在类的HashCode()方法，计算此对象的哈希值，此哈希值决定了
        此对象在Set中的存储位置，若此位置之前没有对象存储，则这个对象直接存入这个位置，若此位置已有对象存储，
        再通过equals()方法比较这两个对象是否相同。若相同则后一个对象则不能够添加到Set中。否则都存储，但是不建议如此
        >要求，hashCode()方法要与equals()方法一致。

     */
    @Test
    public void testHashSet(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(null);  //null也占一个位置
        set.add(new String("AA"));
        Peroson p1 = new Peroson("GG",23);  //不违背不可重复性，此处是根据Person类的equals()方法来判断是否相同，
        Peroson p2 = new Peroson("GG",23);  //此处p1和p2用的是两个不同的地址，但是重写equals()方法依然没体现出不可重复性
                                                         //此处还需要重写HashCode
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());  //哈希值不一样
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);
//        set.add(p1);
//        set.add(p2);
//        System.out.println(set.size());
//        System.out.println(set);    //无序的,无序不表示随机


    }

    //LinkedHashSet
    /*
        LinkedHashSet：使用链表维护了一个添加进集合中的顺序。导致当我们遍历LinkedHashSet集合元素时，
        是按照添加进去的顺序遍历的。  （但它依然是无序的，低层存储是无序的）
        LinkedHashSet插入性能略低于HashSet，但在迭代访问Set里的全部元素时，有很好的性能
     */
    @Test
    public void testLinkedHashSet(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(null);

        Iterator i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());   //遍历出的顺序跟输入一致
        }
    }

    //TreeSet
    /*
        1.向TreeSet中添加的元素必须是同一个类的
        2.可以按照添加进集合中的元素的指定的顺序遍历（像String，包装类等默认从小到大）
        3.当向TreeSet中添加自定义类的对象时，有两种排序方法：自然排序和定制排序
           自然排序：要求自定义类实现java.lang.Comparable接口并重写其compareTo(Object obj)的抽象方法
           在此方法中，指明按照自定义类的哪个属性进行排序
           定制排序:
        4.向TreeSet中添加元素时，首先按照compareTo()方法对两个对象的某属性值进行比较，一旦返回0，
          虽然仅是两个对象的那一个属性值相同，但是程序会认为这两个对象时相同的，进而后一个对象不能添加

        >compareTo()与hashCode()以及equals()三者保持一致！
     */
    @Test
    public void testTreeSet(){
        Set set = new TreeSet();
//        set.add("AA");
//        set.add("BB");
//        set.add("AA");
//        set.add("JJ");
//        set.add("MM");
//        set.add("GG");
        //当Person类没有实现Comparable接口时，当向TreeSet中添加Person对象时，报ClassCastException
        set.add(new Peroson("CC",23));
        set.add(new Peroson("GG",26));
        set.add(new Peroson("MM",20));
        set.add(new Peroson("dd",21));
        set.add(new Peroson("KK",21));
//        System.out.println(set);
        for(Object str:set){
            System.out.println(str);
        }
    }
    //定制排序

    //> compare()与hashCode()以及equals()三者保持一致！
    //与自然排序区别，一种是修改类，一种是在外面定制好如何排序，定制排优先
    @Test
    public void testTreeSet2(){
        //1.创建一个实现了Comparator接口的对象
        Comparator com = new Comparator() {
            //向TreeSet中添加Custormer类的对象，在此compare()方法中，指明按照Customer哪个属性排序的
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer && o2 instanceof Customer){
                    Customer c1 = (Customer)o1;
                    Customer c2 = (Customer)o2;
                    int i = c1.getId().compareTo(c2.getId());
                    if(i == 0)
                        return c1.getName().compareTo(c2.getName());
                    return i;
                }
                return 0;
            }
        };  //本应重写compare()和equals()方法，因为是一个类对象，继承了Object，就有了equals()方法
        //2.将此对象作为形参传递给TreeSet的构造器中
        TreeSet set = new TreeSet(com); //构造器
        //3.向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象
        set.add(new Customer("AA",1003));
        set.add(new Customer("BB",1004));
        set.add(new Customer("GG",1002));
        set.add(new Customer("CC",1005));
        set.add(new Customer("DD",1002));
        for(Object str:set){
            System.out.println(str);
        }
    }
}

