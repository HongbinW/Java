package dynamic_programming;

/**
 * @Author: HongbinW
 * @Date: 2019/4/10 9:01
 * @Version 1.0
 * @Description: LeetCode121
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class Code06_stock1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int max = 0;
        int curmin = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < curmin)
                curmin = prices[i];
            max = prices[i] - curmin > max ? prices[i] - curmin : max;
        }
        return max;
    }
    //DP
    public int maxProfit2(int[] prices){
        if(prices == null || prices.length < 2)
            return 0;
        int res = 0;
        int[][] MP = new int[prices.length][3];
        //三个状态，0表示此时手中没有股票，1表示手中买入股票没卖出，2表示买入股票并卖出
        MP[0][0] = 0;
        MP[0][1] = -prices[0];
        MP[0][2] = 0;
        for(int i = 1; i < prices.length; i++){
            MP[i][0] = MP[i-1][0];
            MP[i][1] = Math.max(MP[i-1][1],MP[i-1][0]-prices[i]);
            MP[i][2] = MP[i-1][1] + prices[i];
            int curMax = getMax(MP[i][0],MP[i][1],MP[i][2]);
            res = res > curMax ? res : curMax;
        }
        return res;
    }
    public static int getMax(int i, int j, int k){
        int res = i > j ? i : j;
        return res > k ? res : k;
    }
}
