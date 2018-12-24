package basic.OOP.O2;

import javax.xml.crypto.Data;

public class TestArgsTransfer1 {
    public static void main(String[] args){
        TestArgsTransfer1 tt = new TestArgsTransfer1();
        DataSwap ds = new DataSwap();
        System.out.println("ds.i: " + ds.i + " ds.j: " + ds.j);
        tt.swap(ds);
        System.out.println(ds); //可见此处的ds与swap方法中形参d的地址相同，也即两个所指对象一致
        System.out.println("ds.i: " + ds.i + " ds.j: " + ds.j);
    }
    public void swap(DataSwap d){
        int temp = d.i;
        d.i = d.j;
        d.j = temp;
        System.out.println(d);
    }
}

class DataSwap{
    int i = 10;
    int j = 5;
}