package basic.Generic;

import java.util.ArrayList;
import java.util.List;

//自定义泛型类
public class MyGeneric<T> {
    private String orderName;
    private int orderId;
    private T t;    //先认为T为一种类型，只是这种类型暂时不确定
    List<T> list = new ArrayList<>();

    //泛型方法
    public <E> E getE(E e){
        return e;
    }
    //实现数组到集合的复制
    public <E> List<E> fromArrayToList(E[] e,List<E> list){
        for(E e1:e){
            list.add(e1);
        }
        return list;
    }

    public void add(){
        list.add(t);
    }
    public T getT(){
        return t;
    }
    public void setT(T t){
        this.t = t;
    }

    public MyGeneric() {
    }

    public MyGeneric(String orderName, int orderId) {
        this.orderName = orderName;
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "MyGeneric{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", t=" + t +
                '}';
    }
}
//继承泛型类或泛型接口时，可以指明泛型的类型
//class SubMyGeneric<T> extends MyGeneric<T>{
class SubMyGeneric extends MyGeneric<Integer>{
}