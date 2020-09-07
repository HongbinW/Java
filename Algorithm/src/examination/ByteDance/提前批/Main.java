package examination.ByteDance.提前批;

import java.util.Scanner;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/23
 */
// Code Forces 原题
// 你n个正整数，每个正整数不会超过100000，你每次可以选择一个在数组中存在的数字k，然后删掉这个数字，
// 并且顺带删掉数组中所有的k+1和k-1，同时获得k点积分，问如何获得尽可能多的积分

// 思路因为最大的数不会超过100000，所以可以设dp[i]为删掉了所有大于等于i的数字能获得的最多积分，那么有
//dp[i] = max(dp[i+1], dp[i+2]+sum[i]*i)，其中sum[i]为第i个数字在数组中出现的次数

//3
//1 2 3
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[1000001];
        for (int i = 0; i < N; i ++){
            arr[sc.nextInt()] ++;
        }
        System.out.println(process(arr));
    }

    public static int process(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = arr[1];
        for (int i = 2; i < arr.length; i ++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i] * i);
        }
        return dp[arr.length - 1];
    }
}
