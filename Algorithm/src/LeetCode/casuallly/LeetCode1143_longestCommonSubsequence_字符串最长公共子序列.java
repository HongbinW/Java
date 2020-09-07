package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/7
 */
public class LeetCode1143_longestCommonSubsequence_字符串最长公共子序列 {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[ch1.length+1][ch2.length+1];
        // text1 1到i 和 text2 1到j 的公共长度
        for (int i = 1; i < dp.length; i ++){
            for (int j = 1; j < dp[0].length; j ++){
                if (ch1[i-1] == ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;        // 相等说明在i-1,j-1的基础上，可以收录到lcs中
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); // 否则，说明不用i或者不用j，即取两者最大
                    // 实际上还可能会i,j都不用，即 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    // 但是i-1,j-1永远都取不到，因为我们定义dp时，说了是1-i，1-j，所以1-i-1,1-j-1，肯定比1-i||1-j小
                }
            }
        }
        return dp[ch1.length][ch2.length];
    }
}
