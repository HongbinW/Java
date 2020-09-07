//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        if(N == 1){
//            System.out.println(0);
//            return;
//        }
//        int[] arr = new int[N];
//        int[][] dp = new int[N][N];
//        for(int i = 0; i < N; i ++){
//            arr[i] = sc.nextInt();
//            dp[i][i] = arr[i];
//        }
//        for(int j = 1; j < N; j ++){
//            for(int i = j-1; i >= 0; i --){
//                dp[i][j] = Integer.MAX_VALUE;
//                for (int k = i; k < j; k ++){
//                    int a = i == k ? dp[i][k]: dp[i][k] * 2;
//                    int b = k + 1 == j ? dp[k+1][j] : dp[k+1][j] * 2;
//                    dp[i][j] = Math.min(a+b,dp[i][j]);
//                }
//            }
//        }
//        System.out.println(dp[0][N-1]);
//    }
//}
//
import java.util.*;

public class Main{
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