package dp.optiamlSolution;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/17
 */
public class LeetCode518_change_零钱兑换II {
    // dp[i][j] 表示使用前i种金币，凑成j的种数
    // dp[i][j] = dp[i-1][j] + (j - coins[i-1] >= 0 ? dp[i][j - coins[i-1]] : 0);
    // dp[i-1][j]不使用第i种金币，dp[i][j - coins[i-1]] 使用第i种金币
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < dp.length; i ++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= coins.length; i ++){
            for(int j = 1; j <= amount; j ++){
                dp[i][j] = dp[i-1][j] + (j - coins[i-1] >= 0 ? dp[i][j - coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    // 可见dp[i][j] 只与dp[i-1][j] 和dp[i][...]有关，因此只保留一个数组即可
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        int n = coins.length;
        for (int i = 0; i < n; i ++){       // 两个for循环不能反，表示添加该种金币时，能在原来基础上
            for (int j = 1; j <= amount; j ++){
                if (j - coins[i] >= 0){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
