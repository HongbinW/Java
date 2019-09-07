package interest;

/**
 * @Author: HongbinW
 * @Date: 2019/9/5 16:31
 * @Version 1.0
 * @Description:
 */
import java.util.*;
public class minEdit_最长回文串的最小修改次数 {
    //思路：先找到最长回文子序列，然后用总长度-该序列，即要修改的最少次数
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s1 = sc.next();
                String s2 = new StringBuilder(s1).reverse().toString();
                int[][] dp = new int[s1.length() + 1][s2.length() + 1];
                for (int i = 1; i < dp.length; i ++ ) {
                    for (int j = 1; j < dp[0].length; j ++ ) {
                        dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
                System.out.println(s1.length() - dp[s1.length()][s2.length()]);
            }
        }

    //dp[i][j]表示从i到j的最长回文长度
    //一定要从后往前，保证子运算已有值
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
