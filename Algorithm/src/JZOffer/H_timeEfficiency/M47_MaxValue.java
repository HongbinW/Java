package JZOffer.H_timeEfficiency;

public class M47_MaxValue {
    public static int maxValue(int[][] arr){
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for (int i = dp.length-2; i >= 0; i--){
            for (int j = dp[0].length-2; j >= 0; j--){
                dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]) + arr[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(maxValue(arr));
    }
}
