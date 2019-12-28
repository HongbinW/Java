package Zuo100.c7;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/4
 */
public class Q4_kindsOfArray_dp {
    public long number1(int n, int k){
        return process1(n,k,1); //当前位置是1时，下一个位置为任意数
    }
    public long process1(int n, int k, int pre){
        if (0 == n){
            return 1L;
        }
        long sum = 0;
        for (int i = pre; i <= k; i ++){        //对于pre-k的数，肯定是可以的
            sum += process1(n-1,k,i);
        }
        for (int i = 1; i < pre; i ++){         //对于1-pre的数，需要保证不可整除
            if (pre % i != 0){
                sum += process1(n-1,k,i);
            }
        }
        return sum % 1000000007L;
    }

    public long number2(int n, int k){
        int[][] dp = new int[n+1][k+1];     //第i个位置，前一个数是j的情况有多少种
        Arrays.fill(dp[0],1);
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i ++){
            for (int j = 0; j < dp[0].length; j ++){
                for (int m = j; m < dp[0].length; m ++){
                    dp[i][j] += dp[i-1][m];
                }
                for (int m = 1; m < j; m ++){
                    if (j % m != 0){
                        dp[i][j] += dp[i-1][m];
                    }
                }
            }
        }
        return dp[n][1];
    }
    //这个算法还可以优化，即，求出每一行的总和，这样在求某个dp的时候，就减去不合格的位置即可（复用了求和）
    //（不用每次都从头走到尾了，可以从1走到当前位置j即可）
    // 而且，还有个好处就是，我们只需要一个数组，然后每次从下往上更新，用总和减去上面的某个值即可

    public static void main(String[] args) {
        System.out.println(new Q4_kindsOfArray_dp().number1(2,2));
        System.out.println(new Q4_kindsOfArray_dp().number2(2,2));
    }
}
