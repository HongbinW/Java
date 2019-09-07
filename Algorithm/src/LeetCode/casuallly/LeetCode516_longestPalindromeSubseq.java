package LeetCode.casuallly;

import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/9/5 16:33
 * @Version 1.0
 * @Description:
 */
public class LeetCode516_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int i = 1; i < dp.length; i ++){
            for (int j = 1; j < dp[0].length; j ++){
                dp[i][j] = s.charAt(i-1) == s2.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode516_longestPalindromeSubseq().longestPalindromeSubseq2("babbb"));
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            for (int j = i + 1; j < n; j++) {
                int t = dp[j];
                if (str[i] == str[j])
                    dp[j] = len + 2;
                len = Math.max(len, t);
            }
        }
        int result = 0;
        for (int d : dp) {
            result = Math.max(result, d);
        }
        return result;
    }

    //dp[i][j]表示从i到j的最长回文长度
    public int longestPalindromeSubseq3(String s) {
        char[] chas = s.toCharArray();
        int n = chas.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chas[i] == chas[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
