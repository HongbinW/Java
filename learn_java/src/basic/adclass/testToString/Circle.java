package basic.adclass.testToString;

public class Circle extends GeometricObject {
    private double radius;

    public Circle(){
//        color = "white";
//        weight = 1.0;
        radius = 1.0;
    }
    public Circle(double radius){
//        this();
        this.radius = radius;
    }
    public Circle(double radius,String color,double weight){
        this.radius = radius;
        this.color = color;
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI * this.radius * this.radius;
    }
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        else if(obj instanceof Circle){
            Circle c1 = (Circle) obj;
            return this.radius == c1.radius;
        }else {
            return false;
        }

    }
    public String toString(){
//        return "圆的半径为: " + this.radius;
        return String.valueOf(radius);
    }
}
