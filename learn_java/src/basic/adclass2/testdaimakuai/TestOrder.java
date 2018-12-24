package basic.adclass2.testdaimakuai;

public class TestOrder {
    public static void main(String[] args){
        Order o1 = new Order();
        System.out.println(o1);
        System.out.println();
        Order o2 = new Order();
        System.out.println(o2);
        System.out.println(Order.getOrderDesc());
    }
}
class Order{
//    private int orderId = 1001;   //代码块与显示初始化按照顺序执行
    private String orderName;
    private static String orderDesc = "默认初始化";
    public Order() {
        System.out.println("我是Order类的空参的构造器");
    }
    //静态的代码块

    //非静态初始化块
    {
        orderId = 1002;
        orderName = "AA";
        orderDesc = "OREDER";
        show2();
        show1();
        System.out.println("I'm static 代码块1");
    }
    {
        orderId = 1003;
        System.out.println("I'm static 代码块2");
    }
    static{
        System.out.println("静态代码块2");
        orderDesc = "I'm a Order";
    }
    static{
        System.out.println("静态代码块1");
//        orderId   //不可对非静态属性赋值
        show2();
    }
    private int orderId = 1001;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public static String getOrderDesc() {
        return orderDesc;
    }

    public static void setOrderDesc(String orderDesc) {
        Order.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public void show1(){}
    public static void show2(){}
}
