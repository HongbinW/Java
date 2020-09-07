package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M8_11_waysToChange_零钱兑换方式 {
    public static void main(String[] args) {
        System.out.println(waysToChange(10));
    }
    public static int waysToChange(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] money = new int[]{1,5,10,25};
        int mod = 1000000007;
        for (int i = 0; i < money.length; i ++){
            for (int j = 1; j < dp.length; j ++){
                if (j - money[i] >= 0){
                    dp[j] = (dp[j-money[i]]+dp[j]) % mod;
                }
            }
        }
        return (int)dp[n];
    }
}
