package JZOFFER2;

import java.util.ArrayList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q46_translateNum_数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
    public static int translateNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0){
            list.add(num%10);
            num /= 10;
        }
        int[] dp = new int[list.size()+1];
        dp[0] = 1;
        for (int i = 0; i < list.size(); i ++){     //从后往前看，dp[i] = dp[i+1] + dp[i+2] 如果满足>=10 && < 26的情况
            if (i > 0){
                int cur = list.get(i) * 10 + list.get(i-1);
                if (cur >= 10 && cur < 26)
                    dp[i+1] = dp[i] + dp[i-1];
                else{
                    dp[i+1] = dp[i];
                }
            }else{
                dp[i+1] = dp[i];
            }
        }
        return dp[list.size()];
    }
}
