package basic.Generic;

import org.junit.Test;

import java.util.*;

/*
    泛型的使用
    1.在集合中使用泛型(掌握)
    2.自定义泛型类、泛型接口、泛型方法
    3.泛型与继承关系
    4.通配符

    泛型不能使用在static中，因为实例化时才会确定泛型类型，而static静态结构在类加载时就加载了
    泛型不能在try-catch中使用泛型的声明
 */
public class TestGeneric {
    // 7.通配符的使用
    @Test
    public void test7(){
        List<String> list = new ArrayList<String>();
        list.add("AA");
        list.add("BB");
        List<?> list1 = list;
        //可以读取声明为通配符的集合类的对象
        Iterator<?> iterator = list1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //不允许向声明为通配符的集合类写入对象，但Null可以
//        list1.add("CC");

    }

    // 6.通配符 ?
    // List<A>,List<B>,...,任何都是List<?>的子类
    // ? extends A :可以存放A及其子类
    // ? extends B :可以存放B及其父类
    @Test
    public void test6(){
        List<?> list = null;
        List<Object> list1 = new ArrayList<Object>();
        List<String> list2 = new ArrayList<String>();
        list = list1;
        list = list2;
        show(list1);
//        show(list2);  //只能放list1，因为指明了泛型
//        show(list);
        show1(list2);
        List<? extends Number> list3 = null;
        List<Integer> list4 = null;
        list3 = list4;
        List<? super Number> list5 = null;
        list5 = list1;  //Object >= Number

    }
    public void show(List<Object> list){

    }
    public void show1(List<?> list){

    }
    //5.泛型与继承的关系
    //若类A是类B的子类，那么List<A>就不是List<B>的子接口
    @Test
    public void test5(){
        Object obj = null;
        String str = "AA";

        Object[] obj1 = null;
        String[] str1 = new String[]{"AA","BB","CC"};
        obj1 = str1;
        System.out.println(obj1);

        List<Object> list = null;
        List<String> list1 = new ArrayList<String>();
//        list = list1;
        //这样是错误的
        //假设list = list1满足，即list也指向list1集合
        //则list.add(123),因为是Object类型的，所以可以添加进去
        //String str = list1.get(0); 出现问题，String类型获取到了Integer类型
        //这两个属于并列关系

    }
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
        Set<Map.Entry<String,Integer>> entry1 = map.entrySet();   //泛型可以相互嵌套
        for(Map.Entry<String,Integer> o:entry1){
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
