package LeetCode.面试题系列;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M1_5_oneEditAway_一次编辑 {
    public boolean oneEditAway2(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len2 > len1) return oneEditAway2(second, first);

        // 保持第一个比第二个长
        for (int i = 0; i < len2; i++){
            if (first.charAt(i) != second.charAt(i)){
                // 如果是长度相同字符串，那就比较下一个，如果长度不一样，那就从该字符开始进行比较。
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }
    public boolean oneEditAway(String first, String second) {
        int[][] dp = new int[first.length()+1][second.length()+1];
        for (int i = 0 ; i < dp.length; i ++){
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j ++){
            dp[0][j] = j;
        }
        for (int i = 1; i < dp.length; i ++){
            for (int j = 1; j < dp[0].length; j ++){
                if (first.charAt(i-1) != second.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[first.length()][second.length()] == 1;
    }
}
