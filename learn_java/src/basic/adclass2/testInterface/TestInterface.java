package basic.adclass2.testInterface;

public class TestInterface {
    public static void main(String[] args){
        ComparableCircle c1 = new ComparableCircle(2.3);
        ComparableCircle c2 = new ComparableCircle(2.1);
        ComparableCircle c3 = new ComparableCircle(2.3);

        int i1 = c1.compreTo(c2);
        int i2 = c1.compreTo(c3);
        int i3 = c2.compreTo(c1);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
    }
}

interface CompareObject{
    public int compreTo(Object o);
}

class Circle{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle(double radius) {
        super(radius);
    }

    public int compreTo(Object o) {

            ComparableCircle s = (ComparableCircle) o;
            if (this.getRadius() - s.getRadius() > 0)
                return 1;
            else if (this.getRadius() - s.getRadius() == 0)
                return 0;
            else
                return -1;

    }
}
