package LeetCode.casuallly;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/21
 */
public class LeetCode322_coinChange_零钱兑换_最少硬币数 {
    public static void main(String[] args) {
        System.out.println(new LeetCode322_coinChange_零钱兑换_最少硬币数().coinChange(new int[]{2,5,10,1},27));
    }
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++){
            for (int j = 0; j < coins.length; j ++){
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
