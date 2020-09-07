package LeetCode.每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/18
 */
public class LeetCode97_isInterleave_交错字符串 {

    // my 10% 10%
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        if (ch1.length + ch2.length != ch3.length){
            return false;
        }
        return process(ch1,ch2,ch3,0,0,0);
    }
    public boolean process(char[] ch1, char[] ch2, char[] ch3, int i, int j, int k){
        if (i == ch1.length){
            return singleCompare(ch2,ch3,j,k);
        }else if (j == ch1.length){
            return singleCompare(ch1,ch3,i,k);
        }
        if (ch1[i] != ch3[k] && ch2[j] != ch3[k]){
            return false;
        }else if (ch1[i] == ch3[k] && ch2[j] == ch3[k]){
            return process(ch1,ch2,ch3,i+1,j,k+1) || process(ch1,ch2,ch3,i,j+1,k+1);
        }else if (ch1[i] == ch3[k]){
            return process(ch1,ch2,ch3,i+1,j,k+1);
        }else{
            return process(ch1,ch2,ch3,i,j+1,k+1);
        }
    }

    public boolean singleCompare(char[] ch1, char[] ch2, int i, int j){
        while (i < ch1.length && j < ch2.length){
            if (ch2[j] == ch1[i]){
                j ++;
                i ++;
            }else{
                break;
            }
        }
        if (j < ch2.length || i < ch1.length){
            return false;
        }else{
            return true;
        }
    }

    // 官方
    // 可见dp[i][j]取决于dp[i-1][j]和dp[i][j-1]因此只取决于上和左两个位置，因此可压缩为dp[m+1]
    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];      // s1的前i和s2的前j个是否能组成s3前i+j个

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p)); // 如果s1和s3匹配
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p)); // 如果s2和s3匹配
                }
            }
        }

        return f[n][m];
    }

}
