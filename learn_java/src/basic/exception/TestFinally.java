package basic.exception;
//finally一定会运行是指在程序跳出前，一定会运行

public class TestFinally {
    public static void main(String[] args){
        int i = method1();
        System.out.println(i);
    }

    public static int method1(){
        try{
            //...
            System.out.println(10/0);
            return 1;       //该语句一直没执行
        }catch (Exception e){
            e.printStackTrace();
            return 3;       //该语句也没有执行
        }finally {
            System.out.println("finally");
            return 2;
        }
    }
}
