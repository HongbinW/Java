package Zuo100.c7;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/5
 */
public class Q7_maxProfits_打气球 {
    public int maxProfits(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[help.length-1] = 1;
        for(int i = 1; i < help.length - 1; i ++){
            help[i] = arr[i-1];
        }
        return process1(help,1,help.length-2);
    }

    //考虑最后打i位置时的收益
    public int process1(int[] arr, int L, int R){
        if (L == R){
            return arr[L-1] * arr[L] * arr[L+1];
        }
        int max = Math.max(
                arr[L-1] * arr[L] * arr[R+1] + process1(arr,L+1,R),
                arr[L-1] * arr[R] * arr[R+1] + process1(arr,L,R-1)
        );
        for (int i = L + 1; i < R;i ++){
            max = Math.max(max,
                    process1(arr,L,i-1) + arr[L-1] * arr[i] * arr[R+1] + process1(arr,i+1,R));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q7_maxProfits_打气球().maxProfits(new int[]{2,5,3}));
        System.out.println(new Q7_maxProfits_打气球().maxProfits2(new int[]{2,5,3}));
    }

    public int maxProfits2(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[help.length-1] = 1;
        for(int i = 1; i < help.length - 1; i ++){
            help[i] = arr[i-1];
        }
        int[][] dp = new int[help.length][help.length];
        for (int i = 1; i < dp.length - 1; i ++){
            dp[i][i] = help[i-1] * help[i] * help[i+1];
        }
        for (int i = 2; i < dp.length - 1; i ++){
            for (int j = i; j < dp.length - 1; j ++){
                for (int k = i; k <= j; k ++){
                    dp[j][j+1] = Math.max(dp[j][j+1],dp[j][k]);
                }
                for (int k = i; k <= j; k ++){
                    dp[j][j+1] = Math.max(dp[j][j+1],dp[k][j+1]);
                }
            }
        }
        return dp[1][dp.length-2];
    }
}
