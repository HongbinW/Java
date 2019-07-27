package Zuo100.c1;

public class Q1_isValid {
    //Q1
    public static boolean isValid(String str){
        if (str == null || str.equals(""))
            return false;
        char[] chs = str.toCharArray();
        int count = 0;
        for (int i = 0 ; i < str.length(); i ++){
            if (str.charAt(i) == '(')
                count ++;
            else
                count --;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
    //Q2
    public static int maxLength(String str){
        if (str == null || str.equals(""))
            return 0;
        int maxLen = 0;
        int[] dp = new int[str.length()];
        for (int i = 1 ; i < str.length(); i ++) {
            if (str.charAt(i) == ')'){
                int pre = i - dp[i-1] - 1;
                if (pre >= 0 && str.charAt(pre) == '('){
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Q1_isValid().maxLength("()(()())"));
    }
}
