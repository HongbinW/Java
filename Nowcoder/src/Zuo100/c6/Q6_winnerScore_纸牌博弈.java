package Zuo100.c6;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/3
 */
public class Q6_winnerScore_纸牌博弈 {
    //递归
    public int winnerScore(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(firstScore(arr,0,arr.length-1),lastScore(arr,0,arr.length-1));
    }

    public int firstScore(int[] arr, int left, int right){
        if (left > right){
            return 0;
        }else if(left == right){
            return arr[left];
        }else{
            return Math.max(arr[left] + lastScore(arr,left+1,right),arr[right] + lastScore(arr,left,right-1));
        }
    }

    public int lastScore(int[] arr, int left, int right){
        if (left >= right){
            return 0;
        }else{
            return Math.min(firstScore(arr,left+1,right),firstScore(arr,left,right-1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q6_winnerScore_纸牌博弈().winnerScore(new int[]{1,100,2}));
        System.out.println(new Q6_winnerScore_纸牌博弈().winnerScore2(new int[]{1,100,2}));
    }

    //将递归写成一个
    //只考虑先拿，后拿用总和减
    public static int process(int[] arr, int left, int right){
        if (left == right){
            return arr[left];
        }else if (left == right - 1){
            return Math.max(arr[left],arr[right]);
        }else{
            return Math.max(arr[left] + Math.min(process(arr,left+2,right),process(arr,left+1,right-1)),
                    arr[right] + Math.min(process(arr,left + 1,right),process(arr,left,right-2)));
        }
    }

    //DP
    public int winnerScore2(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];       //i,j代表的是left,right
        int sum = 0;
        for (int i = 0; i < arr.length; i ++){
            dp[i][i] = arr[i];
            sum += arr[i];
            if (i != arr.length - 1){
                dp[i][i+1] = Math.max(arr[i],arr[i+1]);
            }
        }
        for (int j = 2; j < arr.length; j ++){
            for (int i = j - 2; i >= 0; i --){
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]),
                                    arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        return Math.max(dp[0][arr.length-1],sum - dp[0][arr.length-1]);
    }
}
