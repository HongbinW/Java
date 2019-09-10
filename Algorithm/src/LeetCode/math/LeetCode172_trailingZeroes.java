package LeetCode.math;

/**
 * @Author: HongbinW
 * @Date: 2019/9/1 16:41
 * @Version 1.0
 * @Description:
 */
public class LeetCode172_trailingZeroes {
    //思路：所有只能被5整除的只加一次，所有能被25整除的加两次，所有能被125整除的加三次……
    //所以，先看能被5整除的，加一次，然后看有多少能被25整除的，又加一次，这样就弥补了25有两个的情况……
    public int trailingZeroes(int n) {
        int count = 0;
        int cur = 5;
        while (cur <= n){
            count += n / cur;
            cur *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode172_trailingZeroes().trailingZeroes(25));
    }
}
