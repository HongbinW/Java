package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q49_nthUglyNumber_丑数 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0, three = 0, five = 0;
        for (int i = 1; i < n; i ++){
            if (two < i && dp[two] * 2 <= dp[i-1]){
                two ++;
            }
            if (three < i && dp[three] * 3 <= dp[i-1]){
                three ++;
            }
            if (five < i && dp[five] * 5 <= dp[i-1]){
                five ++;
            }
            dp[i] = Math.min(dp[two]*2,dp[three]*3);
            dp[i] = Math.min(dp[i],dp[five]*5);
        }
        return dp[n-1];
    }
}
