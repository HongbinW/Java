package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/8
 */
public class LeetCode221_maximalSquare_最大正方形 {
    public static void main(String[] args) {
        char[][] chs = new char[][]{{'0','0','0','0'},{'1','0','0','0'},{'0','0','0','0'},
            {'0','0','0','0'}};
        System.out.println(new LeetCode221_maximalSquare_最大正方形().maximalSquare(chs));
    }
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    res = 1;
                    continue;
                }
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j];
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i][j]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
