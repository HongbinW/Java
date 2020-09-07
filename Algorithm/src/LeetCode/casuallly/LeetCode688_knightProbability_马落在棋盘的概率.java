package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/21
 */
public class LeetCode688_knightProbability_马落在棋盘的概率 {
    public static void main(String[] args) {
        System.out.println(new LeetCode688_knightProbability_马落在棋盘的概率().knightProbability2(3, 2, 0, 0));
    }
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[r][c] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = i + dr[k];
                        int cc = j + dc[k];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                            dp2[cr][cc] += dp[i][j] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row : dp) {
            for (double x : row) ans += x;
        }
        return ans;
    }
    public double knightProbability2(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[r][c] = 1;
        for (int times = 0; times < K; times ++) {        // 扫描每个位置，经过K次还留在棋盘上的次数
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = i + dr[k];
                        int cc = j + dc[k];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                            dp2[i][j] += dp[cr][cc];
                        }
                    }
                }
            }
            dp = dp2;
        }
        double count = 0;
        for (double[] rows : dp){
            for (double ddd : rows){
                count += ddd;
            }
        }
        return count / Math.pow(8,K);
    }
}
