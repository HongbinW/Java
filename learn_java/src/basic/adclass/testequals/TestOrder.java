package basic.adclass.testequals;

/**
 * 编写Order类，有int型的orderId，String型的OrderName，
 * 相应的getter()和setter()方法，两个参数的构造器，
 * 重写父类的equals()方法：public boolean equals(Object obj)，
 * 并判断测试类中创建的两个对象是否相等。
 */

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Objects;

public class TestOrder{
    public static void main(String[] args){
        Order o1 = new Order(1001,"AA");
        Order o2 = new Order(1001,"AA");
        System.out.println(o1.equals(o2));
    }
}

class Order {
    private int orderld;
    private String OrderName;

    public int getOrderld() {
        return orderld;
    }

    public void setOrderld(int orderld) {
        this.orderld = orderld;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public Order(int orderld, String orderName) {
        this.orderld = orderld;
        OrderName = orderName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Order) {
            Order o1 = (Order) obj;
            return this.orderld == o1.orderld && this.OrderName.equals(o1.OrderName);   //String的equals方法已重写
        } else {
            return false;
        }
    }
}
