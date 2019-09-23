package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 21:14
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */

/**
 * 思路：双指针，一起往右走，不一样时，就把右边的值赋过来，否则，right++
 */
public class LeetCode26_removeDuplicates_删除数组重复元素 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length){
            if (nums[left] == nums[right]){
                right ++;
            }else{
                nums[++left] = nums[right++];
            }
        }
        return left + 1;
    }
}
