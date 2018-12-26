package basic.exception;
//throws异常处理的一种方式
//throw手动抛出   (throw + 运行时异常对象）
//若是Exception，必须要显示的处理
public class TestShoudongpao {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.3);
        Circle c2 = new Circle(2.3);
        System.out.println(c1.compareTo(c2));
        System.out.println(c1.compareTo(new String("AA")));
    }
}
class Circle{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    //比较两个圆的半径大小
    public int compareTo(Object obj){
        if(this == obj)
            return 0;
        else if(obj instanceof Circle){
            Circle c = (Circle)obj;
            if(this.radius > c.radius)
                return 1;
            else if(this.radius == c.radius)
                return 0;
            else
                return -1;
        }
        else {  //obj如果不是Circle的实例
            //手动抛出一个异常
//            throw new RuntimeException("传入的类型有误!");
            throw new MyException("传入的类型有误!");
        }
    }
}
