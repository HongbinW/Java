package basic.collection;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import javafx.beans.binding.When;
import org.junit.Test;

import java.util.*;

/*
    1.存储对象可以考虑：①数组 ②集合
    2.数组存储对象的特点：Student[] stu = new Student[20]; stu[0] = new Student();……
        >弊端：①一旦创建，其长度不可变。②实际存储量不可直接知
    3.集合
        -----Collection接口
                ----Set：元素无序，不可重复的集合（类似集合）
                ----List:元素有序，可重复的集合（“动态”数组）
        -----Map接口：具有映射关系“key-value对”的集合（类似函数）
 */
public class TestCollection {
    @Test
    public void testCollection1(){
        Collection coll = new ArrayList();
        //1.size():返回集合中元素的个数
        System.out.println(coll.size());
        //2.add(Object obj):向集合中添加一个元素（默认Object类型）
        coll.add(123);  //123是对应的包装类
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        System.out.println(coll.size());
        //3.addAll(Collection coll);//将形参coll包含的所有元素添加到当前集合中
        Collection coll1 = Arrays.asList(1,2,3);    //数组转化为集合
        coll.addAll(coll1);
        System.out.println(coll.size());
        //查看集合元素
        System.out.println(coll);   //该方法已被重写
        //4.isEmpty():判断集合是否为空
        System.out.println(coll.isEmpty());
        //5.clear():清空集合元素
        coll.clear();
        System.out.println(coll.isEmpty());
    }
    @Test
    public void testCollection2(){
        Collection coll = new ArrayList();
        coll.add(123);  //123是对应的包装类
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
//        Peroson p = new Peroson("MM",23);
        coll.add(new Peroson("MM",23));
        System.out.println(coll);
        //6.contains(Object obj):判断集合中是否含有指定的obj元素，包含则true
        //判断依据，根据元素所在类的equals()方法
        //如果存入集合的元素是自定义类的对象，要求自定义类药重写equals()方法
        boolean b1 = coll.contains(123);
        b1 = coll.contains("AA");   //此处为true，是因为String的equals已被重写
        boolean b2 = coll.contains(new Peroson("MM",23));//如果是p，则与集合中元素相同为true,而此处都是new的相同元素，地址值不同，所以为false
        System.out.println(b1);
        System.out.println(b2);
        //7.containsAll(Collection coll):判断当前集合中是否包含coll中所有的元素
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(new String("AA"));
        boolean b3 = coll.containsAll(coll1);
        coll1.add(456);
        System.out.println(coll1);
        System.out.println("#" + b3);
        //8.retainAll(Collection coll):求当前集合与coll的交集，返回给当前集合
        coll.retainAll(coll1);
        System.out.println(coll);
        //9.remove(Object obj):删除集合中obj元素，成功返回true
        boolean b4 = coll.remove("BB");
        System.out.println(b4);
    }
    @Test
    public void testColletion3(){
        Collection coll = new ArrayList();
        coll.add(123);  //123是对应的包装类
        coll.add("AA");
        coll.add(new Date());
        coll.add("BB");
        coll.add(new Peroson("MM",23));

        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(new String("AA"));
        //10.removeAll(Collection coll):求两集合的差集，即从当前集合中删除包含在coll中的元素
        coll.removeAll(coll1);
        System.out.println(coll);
        //11.equals(Object obj):判断两集合元素是否相同
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(new String("AA"));
        System.out.println(coll1.equals(coll2));
        //12.hashCode():
        System.out.println(coll1.hashCode());
        //13.toArray():将集合转化为数组
        Object[] obj = coll.toArray();  //因为啥都有所以用Object
        System.out.println();
        for(int i = 0;i< obj.length;i++){
            System.out.println(obj[i]);
        }
        System.out.println();
        //14.iterator():返回一个Iterator接口实现类的对象,进而实现集合的遍历
        Iterator iterator = coll.iterator();
        //方式一:不用
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //方式二：不用
//        for(int i = 0; i < coll.size();i++){
//            System.out.println(iterator.next());
//        }
        //方式三:用
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
