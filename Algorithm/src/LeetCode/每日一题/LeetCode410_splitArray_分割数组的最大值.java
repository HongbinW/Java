package LeetCode.每日一题;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode410_splitArray_分割数组的最大值 {
    public static void main(String[] args) {
//        System.out.println(splitArray(new int[]{7,2,5,10,8},2));
        System.out.println(splitArray(new int[]{1, 2147483647}, 2));
    }

    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        long[][] dp = new long[m + 1][n + 1];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = sum[j];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j - 1; k >= 0; k--) {
                    dp[i][j] = Math.min(Math.max(sum[j] - sum[k], dp[i - 1][k]), dp[i][j]);
                }
            }
        }
        return (int) dp[m][n];
    }


    public int splitArray2(int[] nums, int m) {
        int left = 0, right = 0;    //left是nums中的最大值，right为数组和，所以left到right为实际res的范围
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {  // 校验当前的mid，是否可以作为分m段的结果
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

}