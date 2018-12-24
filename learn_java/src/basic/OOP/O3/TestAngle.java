package basic.OOP.O3;

/**
 * 编写两个类，TriAngle和TestTriAngle，其中TriAngle中声明私有的底边长base和高height，
 * 同时声明公共方法访问私有变量；另一个类中使用这些公共方法，计算三角形的面积。
 */
public class TestAngle {
    public static void main(String[] args){
        TriAngle t = new TriAngle();
        t.setBase(2.5);
        t.setHeight(4);
        System.out.println("面积为" + t.findArea());
    }
}
class TriAngle{
    private double base;
    private double height;

    public TriAngle(){
        this.base = 1.0;
        this.height = 1.0;
    }
    public TriAngle(double base,double height){
        this.base = base;
        this.height = height;
    }

    public void setBase(double base){
        this.base = base;
    }
    public double getBase(){
        return this.base;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public double findArea(){
        return base * height / 2;   //此处的this省略了
    }
}
