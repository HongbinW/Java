package basic.OOP.O2;
//封装
/**
 * 一、面向对象的特征一：封装与隐藏
 * 问题：当创建了类的对象以后，如果直接通过“对象.属性”的方式对响应的对象属性赋值的话，可能会出现不满足实际情况的以外，
 *       我们考虑不让对象来直接作用属性，而是通过“对象.方法”的形式来控制对象对属性的访问。
 * 解决方法：（封装性的思想）①将类的属性私有化②通过公共的方法（set&get)来是实现调用
 *
 * 权限修饰符：public private 缺省 protected
 *   可以用来修饰方法、属性、构造器
 *
 *
 */
public class TestFZ {
    public static void main(String[] args){
        Animal a1 = new Animal();
//        a1.name = "bb";
//        a1.legs = 4;
        a1.setName("bb");
        a1.setLegs(4);
        a1.info();
    }
}

class Animal{
    private String name;    //私有化，不在类的内部就调用不到
    private int legs;
    String color;   //缺省

    public void eat(){
        System.out.println("eat eat eat");
    }
    public void sleep(){
        System.out.println("sleep sleep");
    }
    public void info(){
        System.out.println("name: "+ name + " legs: " + legs);
    }
    public void setLegs(int l){
        if (l > 0 && l % 2 == 0){
            legs = l;
        }else{
            System.out.println("输入数据有误！");
        }
    }
    public int getLegs(){
        return legs;
    }
    public void setName(String n ){
        //...
        name = n;
    }
    public String getName(){
        return name;
    }
}
