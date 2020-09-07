package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 22:32
 * @Version 1.0
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 */
public class LeetCode123_maxProfit_最多买卖两次 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[][][] arr = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i ++){
            for (int j = 1; j < 3; j ++) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    arr[i][j][0] = 0;           //j记录买入次数
                    arr[i][j][1] = -prices[i];  //虽然是第0天，但是只要手里有股票，则就要-prices[i];
                    continue;
                }
                arr[i][j][0] = Math.max(arr[i - 1][j][0], arr[i-1][j][1] + prices[i]);
                arr[i][j][1] = Math.max(arr[i - 1][j][1], arr[i - 1][j-1][0] - prices[i]);
            }
        }
        return arr[prices.length-1][2][0];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode123_maxProfit_最多买卖两次().maxProfit(new int[]{1,2,3,4,5}));
    }
}
