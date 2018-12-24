package basic.OOP.O1;
/*
 *1、将对象作为参数传递给方法。
题目要求：
（1）定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个findArea()方法返回圆的面积。
（2）定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：
		public void printAreas(Cirlce c, int time)
在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。
例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
在main方法中调用printAreas()方法，调用完毕后输出当前半径值。

1.匿名类对象:创建的类的对象时匿名的
   1）当我们只需要一次调用类的对象时，就可以使用匿名的对象
   2）只能调用一次
 */

public class homework1 {
    public static void main(String[] args) {
        Circle1 c1 = new Circle1();
        PassObject t1 = new PassObject();
        t1.printArea(c1,5);
        System.out.println(c1.radius);

        t1.printArea(new Circle1() , 6);
        new Circle1().show();   //匿名类对象  只在堆中出现过一次，栈中无变量指向它，在使用过一次后，直接清除
    }
}
class Circle1{
    double radius;

    public double findArea() {
        return Math.PI * radius * radius;
    }
    public void show(){
        System.out.println("I'm a circle!");
    }
}
class PassObject{
    public void printArea(Circle1 c,int time){
        for(double i = 1.0;i <= time ; i ++ ,c.radius = i){
            System.out.println(i + "\t\t" + c.findArea());
        }
    }

}

