package basic.adclass.testExtends;


public class TestCylinder {
    public static void main(String[] args){
        Cylinder c = new Cylinder();
//        c.setRadius(2.3);
//        c.setLength(1.2);
        System.out.println(c.findVolume());
        System.out.println(c.findArea());
    }
}
