package LeetCode.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 21:06
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/4sum/
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */

/**
 * 排序，双指针，只是比三数之和多了一层循环
 */
public class LeetCode18_fourSum_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j ++){
                if (j != i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length-1;
                while (left < right){
                    while (left < nums.length && left != j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right >= 0 && right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    if (left >= right){
                        break;
                    }
                    int curSum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (curSum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left ++;
                    }
                    else if (curSum < target) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new LeetCode18_fourSum_四数之和().fourSum(new int[]{-2,-1,0,0,1,2},0);
    }
}
