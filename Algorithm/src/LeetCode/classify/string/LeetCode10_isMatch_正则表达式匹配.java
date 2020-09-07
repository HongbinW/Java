package LeetCode.classify.string;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2019/9/29
 *  https://leetcode-cn.com/problems/regular-expression-matching/
 *  给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class LeetCode10_isMatch_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    // my
    public boolean isMatch2(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        return process(chs,chp,0,0);
    }
    public boolean process(char[] chs, char[] chp, int i, int j){
        if (i == chs.length && j == chp.length){
            return true;
        }
        if (i < chs.length && j == chp.length){
            return false;
        }
        if (j+1<chp.length && chp[j+1] == '*'){ //如果下一个是*
            if ( i < chs.length && (chp[j] == chs[i] || chp[j] == '.')){
                return process(chs,chp,i+1,j) || process(chs,chp,i+1,j+2) || process(chs,chp,i,j+2);    //匹配多个，匹配一个，匹配0个
            }else {
                return process(chs,chp,i,j+2);
            }
        }
        if (i < chs.length && (chs[i] == chp[j] || chp[j] == '.')){
            return process(chs,chp,i+1,j+1);
        }
        return false;
    }
}
