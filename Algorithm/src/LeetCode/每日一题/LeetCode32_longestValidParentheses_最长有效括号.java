package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/4
 */
public class LeetCode32_longestValidParentheses_最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] arr = new int[s.length()];
        int res = 0;
        for(int i = 1; i < s.length(); i ++){
            if (s.charAt(i) == ')'){
                int pre = i - 1 - arr[i-1];
                if (pre >= 0 && s.charAt(pre) == '('){
                    arr[i] = arr[i-1] + 2 + (pre > 0 ? arr[pre-1] : 0);
                }
            }
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
