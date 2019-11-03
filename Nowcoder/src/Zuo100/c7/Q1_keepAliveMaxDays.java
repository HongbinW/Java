package Zuo100.c7;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/3
 */
public class Q1_keepAliveMaxDays {
    public static int keepAliveMaxDays(int x, int p, int f, int d){
        //房租每天x元，水果每个p元，手上有f个水果和d元钱
        int rest = d - x * f;
        if (rest > 0){
            return f + rest / (p + x);
        }else {
            return d / x;
        }
    }
}
