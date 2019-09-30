/**
 * Description
 * Author  HongbinW
 * Date 2019/8/17
 */
public class Test {
    static int index = fun();
    public static int fun(){
        d();
        return 10;
    }
    public static void d(){
        System.out.println("d");
    }
    public static void main(String[] args) {
        System.out.println("abc");
    }
}
