package basic.collection;

import org.junit.Test;

import java.util.*;

/*
    Collection接口
    Map key-Value接口
        |----HashMap:Map主要实现类
        |----LinkedHashMap:
        |----TreeMap:
        |----Hashtable
            |----Properties


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
        Collection col =  map.values();
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
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "------->" + entry.getValue());
        }

    }
}
