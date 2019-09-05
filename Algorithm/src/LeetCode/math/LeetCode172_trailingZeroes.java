package LeetCode.math;

/**
 * @Author: HongbinW
 * @Date: 2019/9/1 16:41
 * @Version 1.0
 * @Description:
 */
public class LeetCode172_trailingZeroes {
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
