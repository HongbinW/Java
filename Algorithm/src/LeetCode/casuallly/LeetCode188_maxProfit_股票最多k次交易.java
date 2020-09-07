package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/17
 */
public class LeetCode188_maxProfit_股票最多k次交易 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        if (k > prices.length / 2){     //关键！
            return maxProfitWithoutK(prices);
        }
        int[][][] dp = new int[prices.length][k+1][2];
        for (int i = 0; i < prices.length; i ++){
            for (int j = 1; j <= k; j ++){
                if (i == 0){
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        int res = 0;
        for (int i = 0; i <= k; i ++){
            res = Math.max(res, dp[prices.length-1][i][0]);
        }
        return res;
    }
    public int maxProfitWithoutK(int[] prices){
        int res = 0;
        for (int i = 1; i < prices.length; i ++){
            if (prices[i] - prices[i-1] > 0){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
