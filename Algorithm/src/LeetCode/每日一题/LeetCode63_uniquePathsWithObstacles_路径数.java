package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/6
 */
public class LeetCode63_uniquePathsWithObstacles_路径数 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0){
            return 0;
        }
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length - 1;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[row][col] = obstacleGrid[row][col] == 0 ? 1 : 0;
        for (int i = obstacleGrid.length - 2; i >= 0; i --){
            if (obstacleGrid[i][col] == 0){
                dp[i][col] = dp[i+1][col];
            }
        }
        for (int i = obstacleGrid[0].length - 2; i >= 0; i --){
            if (obstacleGrid[row][i] == 0){
                dp[row][i] = dp[row][i+1];
            }
        }
        for (int i = row - 1; i >= 0; i --){
            for (int j = col - 1; j >= 0; j --){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
