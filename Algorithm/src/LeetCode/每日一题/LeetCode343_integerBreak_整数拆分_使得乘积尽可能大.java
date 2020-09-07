package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/30
 */
public class LeetCode343_integerBreak_整数拆分_使得乘积尽可能大 {
    public static void main(String[] args) {
        System.out.println(new LeetCode343_integerBreak_整数拆分_使得乘积尽可能大().integerBreak(2));
    }
    public int integerBreak(int n) {
        if (n <= 3){
            return n - 1;
        }
        int count3 = n / 3;
        n = n - count3 * 3;
        if (n <= 1){
            count3 --;
            n += 3;
        }

        int count2 = n / 2;
        int res = 1;
        res *= midMulti(count2,2);
        res *= midMulti(count3,3);
        return res;
    }
    public int midMulti(int count, int base){
        if (count == 0){
            return 1;
        }
        int cur = midMulti(count/2,base);
        if ((count & 0b1) == 0){
            return cur * cur;
        }else{
            return cur * cur * base;
        }
    }
}
