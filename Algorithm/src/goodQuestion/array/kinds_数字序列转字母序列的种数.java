package goodQuestion.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/5 21:20
 * @Version 1.0
 * @Description:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class kinds_数字序列转字母序列的种数 {

    //递归解
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        process2(s.toCharArray(),0);
        return res;
    }
    int res = 0;
    private void process2(char[] chs, int start){
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
                process2(chs,start+1);
                process2(chs,start + 2);
            }else{
                process2(chs,start + 1);
            }
        }else{
            process2(chs,start + 1);
        }
    }
    //动态规划  重点记这个方法即可
    // 2 2 6
    // 3 2 1 1
    public static int numDecodings2(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i --){
            if (s.charAt(i) == '0'){
                dp[i] = 0;
            }else if (i < s.length() - 1){
                int temp = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
                if (temp >= 10 && temp <= 26){
                    dp[i] = dp[i+1] + dp[i + 2];
                }
            }else{
                dp[i] = 1;
            }
        }
        return dp[0];
    }
    //实际只用当前数的后两个数，所以记录这两个数即可
    public static int numDecodings(String s) {
        int y = 1;
        int x = 1;
        for (int i = s.length() - 1; i >= 0; i --){
            int cur;
            if (s.charAt(i) == '0'){
                y = x;
                x = 0;
            }else if (i < s.length() - 1){
                int temp = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
                if (temp >= 10 && temp <= 26){
                    cur = x + y;
                    y = x;
                    x = cur;
                }else{
                    y = x;
                }
            }else{
                cur = 1;
                y = x;
                x = cur;
            }
        }
        return x;
    }
}
