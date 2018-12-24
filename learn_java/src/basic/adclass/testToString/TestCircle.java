package basic.adclass.testToString;

public class TestCircle {
    public static void main(String[] args){
        Circle c1 = new Circle(2.3);
        Circle c2 = new Circle(2.3);
        System.out.println(c1.equals(c2));
        System.out.println(c1);
    }
}
