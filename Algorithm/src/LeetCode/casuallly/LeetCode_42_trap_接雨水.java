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

    public int trap2(int[] height) {
        if (height == null || height.length < 3){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int res = 0;
        while (left <= right){
            if (height[left] < height[right]){
                leftHeight = Math.max(leftHeight,height[left]);
                res += leftHeight - height[left++];
            }else{
                rightHeight = Math.max(rightHeight,height[right]);
                res += rightHeight - height[right--];
            }
        }
        return res;
    }
}
