package basic.OOP.O1;
/*
  方法的重载（overload)
  要求： 1.同一类中 2.方法名必须相同 3.方法的参数列表不同（个数、类型）
  补充： 方法的重载与方法的返回值类型没有关系！
 */

public class OOP_Overload {

}
class OverLoad{
    //定义两个Int型变量的和
    public int getSum(int i,int j){
        return i+j;
    }
    //定义三个int型变量的和
    public int getSum(int i,int j ,int k){
        return i+j+k;
    }
    //定义两个double型变量的和
    public double getSum(double d1,double d2){
        return d1+d2;
    }
    //定义三个double型变量的和
    public void getSum(double d1,double d2,double d3){
        System.out.println(d1+d2+d3);
    }

    //这俩也构成重载
    public void method1(int i ,String str){

    }
    public void method1(String str,int i){

    }
}