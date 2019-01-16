package basic.Generic;

import org.junit.Test;

import java.util.*;

/*
    泛型的使用
    1.在集合中使用泛型
    2.自定义泛型类、泛型接口、泛型方法
    3.泛型与继承关系
    4.通配符
 */
public class TestGeneric {
    //4.使用自定义泛型类
    @Test
    public void test4(){
        // 1.当实例化反省的对象时，指明泛型的类型，
        // 指明后，对应的类中所有使用泛型的位置都变为实例化指定的泛型类型
        // 2.如果我们自定义了泛型类，但是在实例化时没有使用，默认类型是Object类型

        MyGeneric<Boolean> order = new MyGeneric();
        order.setT(true);
        System.out.println(order.getT());
        order.list.add(false);
        order.list.add(true);
        for(boolean t:order.list){
            System.out.println(t);
        }
        System.out.println();
        order.add();
        List<Boolean> list = order.list;
        System.out.println(list);
        System.out.println( );
        SubMyGeneric s = new SubMyGeneric();
        List<Integer> list1 = s.list;
        System.out.println(list1);
        //当通过对象掉泛型方法时，指明泛型方法的类型
        System.out.println(        );
        Integer i = order.getE(34);
        Double d = order.getE(2.3);

        Integer[] in = new Integer[]{1,2,3};    //因为用的是泛型方法，因此虽然之前Order指定的是Boolean类型，但方法可以有自己的泛型，此处用的是Integer
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = order.fromArrayToList(in,list2);
        System.out.println(list3);
    }
    //3.Map
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap();
        map.put("AA",123);
        map.put("GG",745);
        map.put("EE",998);
//        Set<String> set1 = map.keySet();
//        for(String str:set1){
//            System.out.println(str + "---->" + map.get(str));
//        }
        Set<Map.Entry<String,Integer>> set1 = map.entrySet();   //泛型可以相互嵌套
        for(Map.Entry<String,Integer> o:set1){
            System.out.println(o.getKey() + "---->" + o.getValue());
        }
    }

    //2.在集合中使用泛型
    @Test
    public void test2(){
        List<Integer> list = new ArrayList();
        list.add(87);
        list.add(78);
//        list.add(new String("AA"));
//        for(int i = 0;i < list.size();i++){
//            // 2>强制类型转化为int型时，可能会报ClassCastException的异常
//            int score = list.get(i);
//            System.out.println(score);
//        }
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }


    //1.在集合中没有使用泛型的情况下
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(89);
        list.add(87);
        list.add(67);
        // 1>没有使用泛型，任何Object及其子类的对象都可以添加进来
        list.add(new String("AA"));
        for(int i = 0;i < list.size();i++){
            // 2>强制类型转化为int型时，可能会报ClassCastException的异常
            int score = (Integer)list.get(i);
            System.out.println(score);
        }
    }
}
