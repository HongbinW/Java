package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/17
 */
public class LeetCode121_maxProfit_股票买卖1次 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i ++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
