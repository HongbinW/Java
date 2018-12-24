package basic.OOP.O2;

/**
 * 方法的参数传递（重点、难点）
 * 1.形参：方法声明时，方法小括号内的参数。
 *   实参：调用方法时，实际传入的参数的值
 * 2.规则：Java中的参数传递机制：值传递机制
 *   1>形参是基本数据类型的：将实参的值传递给形参的基本数据类型的变量
 *   2>形参时引用数据类型的：将实参的引用类型变量的值（对应的堆空间对象实体的首地址）传递给形参的引用类型变量
 *                           所以此处形参和实参指向的是同一对象
 *
 */
public class TestArgsTransfer {
    public static void main(String[] args){
        int i = 10;
        int j = 5;
        System.out.println("i: " + i + " j: " + j);
//        int temp = i;
//        i = j;
//        j = temp;
        TestArgsTransfer tat = new TestArgsTransfer();
        tat.swap(i,j);      //将i的值传给m，将j的值传给n，在swap方法中的操作影响不到main函数中的i和j
                            //看好改变的是谁的变量，打印的又是谁的变量，画好框图
        System.out.println("i: " + i + " j: " + j);
    }
    public void swap(int m,int n){
        int temp = m;
        m = n;
        n = temp;
    }
}
