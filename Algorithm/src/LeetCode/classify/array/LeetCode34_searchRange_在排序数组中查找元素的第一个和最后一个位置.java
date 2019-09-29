package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 22:06
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */

/**
 * 思路：二分查找，找到想要的元素时，继续二分找左边界和右边界
 */
public class LeetCode34_searchRange_在排序数组中查找元素的第一个和最后一个位置 {
    // 100% 70.35%
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] res = new int[]{process(nums,target,true),process(nums,target,false)};
        return res;
    }
    public int process(int[] arr, int target, boolean flag){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = left + ((right - left) >>> 1);
            if (arr[mid] == target){
                if (flag) {
                    if (mid == 0 || arr[mid - 1] != target) {
                        return mid;
                    } else {
                        right--;
                    }
                }else{
                    if (mid == arr.length - 1 || arr[mid + 1] != target){
                        return mid;
                    }else{
                        left ++;
                    }
                }
            }else if (arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
