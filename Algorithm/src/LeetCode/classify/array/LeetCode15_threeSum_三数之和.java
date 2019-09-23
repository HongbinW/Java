package LeetCode.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 20:41
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/3sum/
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */

/**
 * 思路：排序，双指针
 * 难点，去重
 */
public class LeetCode15_threeSum_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                while (left < nums.length && left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right >= 0 && right != nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                }
                if (left >= right){
                    break;
                }
                if (nums[left] + nums[right] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return res;
    }
}
