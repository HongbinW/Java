package LeetCode.每日一题;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/12
 */
public class LeetCode174_calculateMinimumHP_地下城游戏 {
    public static void main(String[] args) {
        int[][] d = new int[][]{{2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new LeetCode174_calculateMinimumHP_地下城游戏().calculateMinimumHP(d));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);       // 如果minn-dungeon[i][j] < 1 ，说明此处需要1滴血就可以了
            }
        }
        return dp[0][0];
    }
}
