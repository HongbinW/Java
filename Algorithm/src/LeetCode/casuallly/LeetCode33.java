package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/4/23 16:36
 * @Version 1.0
 * @Description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class LeetCode33 {
    public static int search(int[] nums, int target) {
        if(nums == null)
            return -1;
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] <= nums[r]){
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(nums[mid] > target && target >= nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3};
        System.out.println(search(nums,5));
    }
}
