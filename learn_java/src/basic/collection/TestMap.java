package basic.collection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
    Collection接口
    Map key-Value接口
        |----HashMap:Map主要实现类
        |----LinkedHashMap:使用链表维护添加进Map中的顺序，故遍历map时是按添加的顺序遍历的
        |----TreeMap:按照添加进Map中的元素key的指定属性进行排序(key就是个TreeSet)要求key必须是同一个类的对象
        |----Hashtable：古老的实现类，线程安全，不建议使用
            |----Properties：常用来处理属性文件。键和值都为String类型


 */
public class TestMap {
    /*
    添加删除操作
    Object put(Object key,Object value)：向Map中添加一个元素
    Object remove(Object key):按照指定的Key删除此key-value对
    void putAll(Map t)
    void clear():清空
    元素查询操作
    Object get(Object key)：获取指定key的value值,若无此Key则返回null
    boolean containsKey(Object key)
    boolean containsValue(Object value)
    int size()：返回集合的长度
    boolean isEmpty()
    boolean equals(Object obj)

    HashMap:
    1.Key是用Set来存放的，不可重复。Value使用Collection来存放的，可重复
    一个Key-value对，是一个Entry。所有的Entry是用Set来存放的，也是不可重复的
    2.向HashMap调用元素时，会调用Key所在类的equals()方法，判断两个Key是否相同，若相同，则旧的会被覆盖掉。

     */
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put("AA",213);
        map.put("BB",456);
        map.put("BB",45);
        map.put(123,"CC");
        map.put(null,null);
        map.put(new Peroson("DD",23),89);
        map.put(new Peroson("DD",23),87);
        System.out.println(map.size());
        System.out.println(map);
        map.remove("BB");
        System.out.println(map);
        Object value = map.get(123);
        System.out.println(value);
    }

    //如何遍历Map
    /*
    Set keySet()
    Collection values()
    Set entrySet()
     */
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",213);
        map.put("BB",456);
        map.put(123,"CC");
        map.put(null,null);
        map.put(new Peroson("DD",23),89);

        //1.遍历key集
        Set set = map.keySet();
        for(Object obj:set){
            System.out.println(obj);
        }
        System.out.println();
        //2.遍历value集
        Collection col = map.values();
        Iterator i = col.iterator();
        while(i.hasNext()){
            System.out.println(i.next());   //跟遍历key的顺序是一样的
        }
        //3.如何遍历key-value对
        //方式一：
        Set set1 = map.keySet();
        for(Object obj:set1){
            System.out.println(obj + "------->" + map.get(obj));
        }
        System.out.println();
        //方式二：
        Set set2 = map.entrySet();
        for(Object obj:set2){
            Map.Entry entry = (Map.Entry)obj;       //Map.Entry是一个接口
            System.out.println(entry.getKey() + "------->" + entry.getValue());
        }

    }
    //LinkedHashMap
    @Test
    public void test3(){
        Map map = new LinkedHashMap();
        map.put("AA",213);
        map.put("BB",456);
        map.put(123,"CC");
        map.put(null,null);
        map.put(new Peroson("DD",23),89);
                                                                                //Map没有Iterator?对！
        Set set1 = map.keySet();
        for(Object obj:set1){
            System.out.println(obj + "---->" + map.get(obj));
        }
    }
    //TreeMap
    //自然排序 VS 定制排序
    //自然排序
    @Test
    public void Test4(){
        Map map = new TreeMap();
        map.put(new Peroson("AA",123),89);
        map.put(new Peroson("BB",13),99);
        map.put(new Peroson("GG",13),29);
        map.put(new Peroson("EE",23),59);
        Set set1 = map.keySet();
        for(Object obj:set1){
            System.out.println(obj + "---->" + map.get(obj));
        }
    }
    //定制排序
    @Test
    public void test5(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {  //传过来的两个对象是Peroson的，因此无法获取value值
                if(o1 instanceof Peroson && o2 instanceof Peroson){
                    Peroson p1 = (Peroson)o1;
                    Peroson p2 = (Peroson)o2;
                    int i = p1.compareTo(p2);
                    if(i == 0){
                        return p1.getAge().compareTo(p2.getAge());
                    }
                    return i;
                }
                return 0;
            }
        };
        Map map = new TreeMap(com);
        map.put(new Peroson("AA",123),89);
        map.put(new Peroson("BB",13),99);
        map.put(new Peroson("GG",13),29);
        map.put(new Peroson("EE",23),59);
        Set set1 = map.keySet();
        for(Object obj:set1){
            System.out.println(obj + "---->" + map.get(obj));
        }
    }
    //使用Properties处理属性文件
    @Test
    public void test6() throws FileNotFoundException,IOException {
        Properties pros = new Properties();
        pros.load(new FileInputStream(new File("src/basic/collection/jdbc.properties")));
        String user = pros.getProperty("user");
        System.out.println(user);
        String password = pros.getProperty("password");
        System.out.println(password);
    }
}
