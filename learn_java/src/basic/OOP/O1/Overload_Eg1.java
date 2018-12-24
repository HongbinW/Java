package basic.OOP.O1;

import javax.rmi.ssl.SslRMIClientSocketFactory;

/*
 *题目一：
 * 编写程序，定义三个重载方法并调用。方法名为mOL。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
在主类的main ()方法中分别用参数区别调用三个方法。
 *题目二:
 * 定义三个重载方法max()，第一个方法求两个int值中的最大值，第二个方法求两个double值中的最大值，
 * 第三个方法求三个double值中的最大值，并分别调用三个方法。


 */
public class Overload_Eg1 {
    public static void main(String[] args){
        int i = 3 , j = 4;
        String str = "whb";
        Overload_Eg1 test = new Overload_Eg1();
        test.mOL(i);
        test.mOL(i,j);
        test.mOL(str);

        System.out.println(test.max(1,3));  //若注释掉对应的int方法，则自动调用double型，自动转换
        System.out.println(test.max(1.1,3.2));
        System.out.println(test.max(2.3,4.6,5.7));
    }
    public void mOL(int i){
        System.out.println(i*i);
    }
    public void mOL(int i,int j){
        System.out.println(i*j);
    }
    public void mOL(String str){
        System.out.println(str);
    }

    public double max(double d1,double d2 , double d3){
        return (max(d1,d2) > d3) ? max(d1,d2) : d3;
    }
    public double max(double d1,double d2 ){
        return (d1 > d2)? d1 : d2 ;
    }
    public int max(int i, int j ){
        return (i > j)? i : j ;
    }
}


