package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 12:19
 * @Version 1.0
 * @Description:
 */
public class LeetCode62_uniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m-1; i ++){
            dp[i][n-1] = 1;
        }
        for (int i = 0; i < n-1; i ++){
            dp[m-1][i] = 1;
        }
        for (int i = m-2; i >= 0; i --){
            for (int j = n - 2; j >= 0; j --){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

}
