package dp.optiamlSolution;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/16
 */

//https://www.nowcoder.com/test/question/done?tid=33424591&qid=894533#summary
public class NowCoder_meituan_2020_9 {

    public static class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] money = new int[n+1];
            int[] preSum = new int[n+1];
            for(int i = 1; i <= n; i++){
                money[i] = sc.nextInt();
                if(i == 1) preSum[i] = money[i];
                else preSum[i] = preSum[i-1] + money[i];
            }
            sc.close();

            //i == j dp[i][j] = 0，一个金币堆，无须合并
            //i,k,j  dp[i][j] = dp[i][k] + dp[k+1][j] + sum,    dp[i][j]表示从i到j合并所需的成本，sum表示这段的金币和，即最后的合成成本，dp[i][k]表示从i到k的成本
            int[][] dp = new int[n + 1][n + 1];
            for(int len = 2; len <= n; len++){
                for(int i = 1; i <= n - len + 1; i++){
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    int sum = preSum[j] - preSum[i - 1];
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k + 1][j] + sum);
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}
