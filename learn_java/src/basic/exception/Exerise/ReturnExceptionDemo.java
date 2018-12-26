package basic.exception.Exerise;
//finally一定会运行是指在程序跳出前，一定会运行
public class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常"); //抛出异常相当于程序跳出去了，但是因为有finally所以要先finally
        } finally {
            System.out.println("用A方法的finally");
        }
    }
    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;                                     //在return前，要先finally
        } finally {
            System.out.println("调用B方法的finally");
        }
    }
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage()); //Message就是方法A中抛出的MSG
        }
        methodB();  //由于前述异常已处理，所以可以执行
    }
}

