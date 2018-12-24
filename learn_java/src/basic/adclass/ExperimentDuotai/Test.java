package basic.adclass.ExperimentDuotai;

public class Test {
    public static void main(String[] args){
        Test t = new Test();
        GeometricObject g = new GeometricObject();
        Circle c1 = new Circle(2.3,"Green",1.0);
        Circle c2 = new Circle(2.3,"Red",1.0);
        MyRectangle m = new MyRectangle(2.3,3.0,"Blue",2.0);

        t.displayGeometricObject(c2);
        boolean b = t.equalsArea(m,c2);
        System.out.println(b);


    }
    //判断两个面积是否相等
    public boolean equalsArea(GeometricObject g,GeometricObject p){
//        if (g.findArea() == p.findArea())
//            return true;
//        else
//            return false;
        return g.findArea() == p.findArea();
    }
    public void displayGeometricObject(GeometricObject g){ //GeometricObject g = new Circle(2.3,"Red",1.0);
        System.out.println("面积： "+ g.findArea());
    }


}
