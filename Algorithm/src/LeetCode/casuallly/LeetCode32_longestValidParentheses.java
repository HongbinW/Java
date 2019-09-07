package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/9/6 18:07
 * @Version 1.0
 * @Description:
 */
public class LeetCode32_longestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        int res = 0;
        for (int i = 1; i < dp.length; i ++){
            if (i > 1 && s.charAt(i-1) == ')'){
                if (s.charAt(i-2) == '('){
                    dp[i] = dp[i-1] + 2;
                    if (i - 2 > 0){
                        dp[i] += dp[i-2];
                    }
                }else{
                    if (i - 2 - dp[i-1] >= 0 && s.charAt(i - 2 - dp[i-1]) == '('){
                        dp[i] = dp[i-1] + 2;
                    }
                    if (i - 2 - dp[i-1] >= 0){
                        dp[i] = dp[i-1-dp[i-1]];
                    }
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }
}
