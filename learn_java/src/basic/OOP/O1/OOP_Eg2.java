package basic.OOP.O1;
/*
 *利用面向对象的编程方法，设计类Circle计算圆的面积。
 */
public class OOP_Eg2 {
    public static void main(String[] args){
        Circle c1 = new Circle();
        c1.r = 2.3;
        c1.size();

    }
}
class Circle{
    double r,S;
    public void size(){
        System.out.println(3.14 * r * r);
    }
    public void getr(double n){
        r = n;
    }
}