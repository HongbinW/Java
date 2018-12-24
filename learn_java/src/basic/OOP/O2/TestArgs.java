package basic.OOP.O2;
/**
 * 可变个数的形参的方法：
 * 1.格式：对于方法的形参： 数据类型 ... 形参名
 * 2.可变个数的形参的方法依然与同名方法之间构成重载
 * 3.可变个数的形参在调用时，个数从0开始到无穷多个都可以
 * 4.使用可变个数形参的方法与方法的形参使用数组是一致的
 * 5.方法中有可变个数的形参，一定要在形参列表最后
 * 6.方法中，只能有一个可变个数的形参
 */

public class TestArgs {
    public static void main(String[] args) {
        TestArgs t = new TestArgs();
        t.sayHello();
        t.sayHello(new String[]{"Hello China", " Hello Beijing"});
        t.sayHello("Hello China", " Hello Beijing");
    }

    //如下三个方法构成重载
    public void sayHello() {
        System.out.println("Hello World!");
    }

    public void sayHello(String str1) {
        System.out.println("Hello World!" + str1);
    }

    //可变个数的形参的方法，包含以上两种情况，所以可省略以上两种方法
    public void sayHello(String... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Hello World!" + args[i]);
        }
    }

    public void sayHello1(String[] args) {       //如说明4，虽然这个传的是数组，但实际上跟上一段代码性质相同，
        // 所以依然不能重名，否则会被认定为同一段代码。
        for (int i = 0; i < args.length; i++) {
            System.out.println("Hello World!" + args[i]);
        }
    }

    public void sayHello(int i, String... args) {    //不可调换，见说明5
        System.out.println(i);
        for (int j = 0; j < args.length; j++) {
            System.out.println("$" + args[j]);
        }
    }
    //可变个数形参的使用例子       注意遍历方式
    public int getSum(int ... args){
        int sum = 0;
        for (int i = 0;i <args.length;i++){
            sum += args[i];
        }
        return sum;
    }

}
