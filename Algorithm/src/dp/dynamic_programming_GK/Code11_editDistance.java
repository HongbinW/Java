package dp.dynamic_programming_GK;

/**
 * @Author: HongbinW
 * @Date: 2019/4/14 14:46
 * @Version 1.0
 * @Description: LeetCode72
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 */
public class Code11_editDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n=word2.length();
        int[][] dp = new int[m+1][n+1];     //单词的范围是0-m，所以是m+1
        //要去匹配0个字符，把当前字符全删掉
        for(int i = 0; i < m+1 ; i++){
            dp[i][0] = i;
        }
        //用0个字符去匹配j个字符，需要去添加j个字符
        for(int j = 0; j < n+1; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "intention", word2 = "";
        System.out.println(minDistance(word1,word2));
    }
}
