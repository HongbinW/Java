package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 22:31
 * @Version 1.0
 * @Description:
 */
public class LeetCode309_maxProfit_股票含一天冷却期 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i ++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],(i - 2 >= 0 ? dp[i-2][0] - prices[i] : dp[i-1][0] - prices[i])); //一直买前两天的股票
        }
        return dp[prices.length-1][0];
    }
}
