package questions;

class Root{
    static{
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }
    public Root(){
        System.out.println("Root的无参数的构造器");
    }
}

class Mid extends Root {
    static{
        System.out.println("Mid的静态初始化块");
    }
    {
        System.out.println("Mid的普通初始化块");
    }
    public Mid(){
        System.out.println("Mid的无参数的构造器");
    }
    public Mid(String msg){
        //通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值："
                + msg);
    }
}

class Leaf extends Mid {
    static{
        System.out.println("Leaf的静态初始化块");
    }
    {
        System.out.println("Leaf的普通初始化块");
    }
    public Leaf(){
        //通过super调用父类中有一个字符串参数的构造器
        super("尚硅谷");
        System.out.println("执行Leaf的构造器");
    }
}

public class TestLeaf{
    public static void main(String[] args){
        new Leaf();
        //new Leaf();
        System.out.println();
        new Leaf();
    }
}

//类的代码块随类的加载而加载，首先加载的是静态代码块，挨着个执行完毕后
//按着父类---->子类的顺序，依次执行该类中要初始化运行的部分