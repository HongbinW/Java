package examination.vivo.preInterview;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/7
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(drop(K,N));
    }
    public static int drop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for(int i = 1; i < N+1; i ++){
            dp[1][i] = i;
        }
        for(int i = 1; i < K+1; i ++){
            dp[i][1] = 1;
        }
        for(int i = 2; i < K+1; i ++){
            for(int j = 2; j < N+1; j ++){
                int left = 1;
                int right = j;

                while(left + 1 < right){        //一定要有+1，因为相交的点可能在left和right中间的非整数部分，或者让left = mid + 1
                    int mid = left + (right - left) / 2;
                    if(dp[i][j-mid] > dp[i-1][mid-1]){
                        left = mid;
                    }else{
                        right = mid;
                    }
                }
                dp[i][j] = Math.min(Math.max(dp[i][j-left],dp[i-1][left-1]),        //最小值一定要么就是left要么就是left+1（这俩点都在交点周围）
                        Math.max(dp[i][j-left-1],dp[i-1][left]))+1;
            }
        }
        return dp[K][N];
    }
}
