package LeetCode.casuallly;

/**
 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 示例 1:

 输入: "12"
 输出: 2
 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2:

 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

 */
public class LeetCode91_numDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        process(s.toCharArray(),0);
        return res;
    }
    int res = 0;
    private void process(char[] chs, int start){
        if (start == chs.length){
            res ++;
            return;
        }

        if (chs[start] == '0'){
            return;
        }
            if (start < chs.length - 1) {
                int temp = (chs[start] - '0') * 10 + chs[start + 1] - '0';
                if (temp >= 1 && temp <= 26){
                    process(chs,start+1);
                    process(chs,start + 2);
                }else{
                    process(chs,start + 1);
                }
            }else{
                process(chs,start + 1);
            }

    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;        //最后一个为0，则最后一个必须要跟别的组，所以起始为0
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public int numDecodings4(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int a = 1;
        int b = 1;
        if (s.charAt(0) == '0'){
            a = 0;
        }
        for (int i = 1 ; i < s.length(); i ++){
            if (s.charAt(i) == '0'){
                a = 0;  //不用管b了，因为这一位为0，且没成功与前一位组成10或20，则最终结果只能为0
            }
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6'){
                a = b + a;
                b = a - b;
            }else{
                b = a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode91_numDecodings().numDecodings4("3013"));
    }
}
