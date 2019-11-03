package Zuo100.c6;

/**
 * Description
 * Author  HongbinW
 * Date 2019/10/30
 */
// (K,T) = (K-1,T-1)+(K-1,T+1)
public class Q5_kindsOfPaths_机器人左右移动走法 {
    public static int kindsOfPaths(int N, int P, int K, int T) {
        int[][] dp = new int[K][N];
        dp[0][P] = 1;
        for (int i = 1; i < K; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N - 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[K-1][T];
    }

    public static int f2(int N, int P, int K, int T) {  //T 当前位置
        if (N < 2 || P < 0 || P >= N || K < 1 || T >= N) {
            return 0;
        }
        if (K == 1) {
            return P == T ? 1 : 0;
        }
        if (T == 0) {
            return f2(N, P, K - 1, T + 1);
        } else if (T == N - 1) {
            return f2(N, P, K - 1, T - 1);
        }
        return f2(N, P, K - 1, T + 1) + f2(N, P, K - 1, T - 1);
    }

    public static void main(String[] args) {
        System.out.println(kindsOfPaths(10,3,6,8));
        System.out.println(f2(10,3,6,8 ));
    }
}
