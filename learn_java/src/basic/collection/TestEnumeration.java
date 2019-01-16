package basic.collection;

import java.util.Enumeration;
import java.util.StringTokenizer;

//Enumeration 接口是 Iterator 迭代器的 “古老版本”
public class TestEnumeration {
    public static void main(String[] args) {
        Enumeration e = new StringTokenizer("ab-c*-df-g","-");  //按照"-"切割
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}
