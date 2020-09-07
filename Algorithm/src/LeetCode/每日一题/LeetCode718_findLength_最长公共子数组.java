package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/1
 */
public class LeetCode718_findLength_最长公共子数组 {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0){
            return 0;
        }
        int[][] dp = new int[A.length+1][B.length+1];
        int res = 0;
        for (int i = 1; i < dp.length; i ++){
            for (int j = 1; j < dp[0].length; j ++){
                if (A[i-1] == B[j-1]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1] + 1);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
