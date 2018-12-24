package basic.adclass.testExtends;

public class Cylinder extends Circle {
    private double length;

    public Cylinder(){
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double findVolume(){
        return super.findArea() * length;
    }
    //重写父类Circle的方法，求圆柱的表面积
    public double findArea(){
        //return 3.14 * this.getRadius() * this.getRadius() * 2 + 2 * 3.14 * this.getRadius() * this.length;
        return super.findArea() * 2 + 2 * 3.14 * this.getRadius() * this.length;
    }

}
