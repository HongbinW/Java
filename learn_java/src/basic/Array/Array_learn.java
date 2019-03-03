package basic.Array;

public class Array_learn {
    public static void main(String[] args){

        //1.如何定义一个数组
        //1.1数组的声明
//        String[] names;
        int[] scores;
        //1.2初始化
        //静态初始化：初始化数组与给数组元素赋值同时进行
        String[] names = new String[]{"张三","Eric","Frank"}; // String[] names = {"张三","Eric","Frank"}这也是可以的

        //动态初始化:分开进行
        scores =  new int[4];
        
        //2.如何调用相应的数组元素
        scores[0] = 87;
        scores[1] = 89;
        scores[3] = 98;
        //3.数组长度：通过数组length属性
        System.out.println(names.length);
        System.out.println(scores.length);
        //4.遍历数组元素
        for(int i = 0;i<names.length;i++){
            System.out.println(names[i]);
        }
        for(int i = 0;i<scores.length;i++){
            System.out.println(scores[i]);
        }
        //数组一旦初始化，长度不可变

        //对于基本数据类型的变量创建的数组：byte short int long float double char boolean
        //1.对于byte short int long而言，创建数组后，默认值为0；
        //2.对于float double而言，默认值为0.0
        //3.对于char而言，默认为空格
        //4.对于boolean而言，默认为false
        //5.对于引用类型的变量构成的数组而言，默认初始化值为null，以string为例
            //*****除了基本数据类型，其他都是引用类型**********
    }
}
