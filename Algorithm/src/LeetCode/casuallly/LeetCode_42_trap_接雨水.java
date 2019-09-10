package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/9/9 15:36
 * @Version 1.0
 * @Description:
 */
public class LeetCode_42_trap_接雨水 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i = 1; i < height.length; i ++){
            left[i] = Math.max(left[i-1],height[i-1]);
            right[height.length-1-i] = Math.max(right[height.length-i],height[height.length-i]);
        }
        int res = 0;
        for(int i = 0; i < height.length; i ++){
            int temp = Math.min(left[i],right[i]) - height[i];
            res += temp > 0 ? temp : 0;
        }
        return res;
    }
}
