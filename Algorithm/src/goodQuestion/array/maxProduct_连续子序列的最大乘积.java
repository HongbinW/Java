package goodQuestion.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/4 22:10
 * @Version 1.0
 * @Description:
 *  * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: [2,3,-2,4]
 *  * 输出: 6
 *  * 解释: 子数组 [2,3] 有最大乘积 6。
 *  * 示例 2:
 *  *
 *  * 输入: [-2,0,-1]
 *  * 输出: 0
 *  * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class maxProduct_连续子序列的最大乘积 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if (nums[i] > 0){
                dp[0][i] = Math.max(dp[0][i-1] * nums[i],nums[i]);
                dp[1][i] = Math.min(dp[1][i-1] * nums[i],nums[i]);
            }else{
                dp[0][i] = Math.max(dp[1][i-1] * nums[i],nums[i]);
                dp[1][i] = Math.min(dp[0][i-1] * nums[i],nums[i]);
            }
        }
        int res = dp[0][0];
        for (int i = 1; i < nums.length; i ++){
            res = Math.max(res,dp[0][i]);
        }
        return res;
    }
    public static int maxProduct2(int[] nums) {
        int[][] DP = new int[2][2];
        DP[0][1] = nums[0];
        DP[0][0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int x = i % 2;      //滚动数组，每次都是[x][0]代表当前最大值，[x][1]代表当前最小值
            int y = (i-1) % 2;
            DP[x][0] = getMax(DP[y][0] * nums[i],DP[y][1] * nums[i], nums[i]);
            DP[x][1] = getMin(DP[y][0] * nums[i],DP[y][1] * nums[i], nums[i]);
            res = Math.max(res,DP[x][0]);
        }
        return res;
    }
    public static int getMax(int i, int j, int k){
        int res = i > j ? i : j;
        return res > k ? res : k;
    }
    public static int getMin(int i, int j, int k){
        int res = i < j ? i : j;
        return res < k ? res : k;
    }
}
