package dp.dynamic_programming_GK;

/**
 * @Author: HongbinW
 * @Date: 2019/4/14 13:57
 * @Version 1.0
 * @Description: LeetCode322
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Code10_coinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] DP = new int[amount+1];//起始是0，最终走到amount，所以需要amount+1个格子
        DP[0]=0;
        for(int i = 1; i <= amount; i++){
            DP[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0)
                    DP[i] = Math.min(DP[i] , DP[i-coins[j]] + 1);
            }
        }
        return DP[amount] <= amount ? DP[amount] : -1;
    }
}
