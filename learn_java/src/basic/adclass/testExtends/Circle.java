package basic.adclass.testExtends;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Circle {
    private double radius;

    public Circle(){
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return radius * radius * Math.PI;
    }

}
