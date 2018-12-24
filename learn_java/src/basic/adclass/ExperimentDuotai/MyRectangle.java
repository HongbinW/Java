package basic.adclass.ExperimentDuotai;

import java.util.Objects;

public class MyRectangle extends GeometricObject{
    private double width;
    private double height;

    public MyRectangle(double width,double height,String coler,double weight){
        super(coler,weight);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea() {
        return this.height * this.width;
    }
}


