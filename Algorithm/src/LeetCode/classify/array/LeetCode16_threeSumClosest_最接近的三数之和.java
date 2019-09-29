package LeetCode.classify.array;

import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 20:56
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/3sum-closest/
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 */

/**
 * 思路：排序，双指针
 */
public class LeetCode16_threeSumClosest_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length; i ++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                while (left < nums.length && left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right >= 0 && right != nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                }
                if (left >= right){
                    break;
                }
                int curSum = nums[i] + nums[left] + nums[right];
                if (closestDiff > Math.abs(curSum - target)){
                    closestDiff = Math.abs(curSum - target);
                    closestSum = curSum;
                }
                if (curSum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return closestSum;
    }
}
