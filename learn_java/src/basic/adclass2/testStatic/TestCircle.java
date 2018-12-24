package basic.adclass2.testStatic;
//static 应用
public class TestCircle {
    public static void main(String[] args){
        Circle c1 = new Circle(2.0);
        Circle c2 = new Circle(2.1);
        System.out.println(Circle.getTotal());
        Circle.show();
        c1.setInfo("I'm a beautiful Circle");
        Circle.show();
    }
}

class Circle{
    private double radius;
    private static String info = "I'm a Circle";
    private static int total = 0;   //因为是static变量，可以用来记录创建的对象个数，若为非静态，则为1

    public Circle(double radius){
        this.radius = radius;
        total++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }

    public static String getInfo() {
        return info;
    }

    public static void setInfo(String info) {
        Circle.info = info;
    }
    public static void show(){
        System.out.println(info);
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
