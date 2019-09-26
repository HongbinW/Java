package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/26 21:54
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/minimum-path-sum/
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

/**
 * 经典DP
 */
public class LeetCode64_minPathSum_最小路径和 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int i = grid[0].length - 2; i >= 0; i --){
            dp[m-1][i] = dp[m-1][i+1] + grid[m-1][i];
        }
        for (int i = grid.length - 2; i >= 0; i --){
            dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];
        }
        for (int i = m-2; i >= 0; i --){
            for (int j = n - 2; j >= 0; j --){
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
