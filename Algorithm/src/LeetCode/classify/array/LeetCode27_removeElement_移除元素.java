package LeetCode.classify.array;

import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 21:19
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/remove-element/
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */

/**
 * 思路：双指针，不等就修改
 */
public class LeetCode27_removeElement_移除元素 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return partition(nums,val);
    }
    public int partition(int[] nums, int val){
        int left = 0;
        int right = nums.length-1;
        int index = 0;
        while (index < right){
            if (nums[index] == val){
                swap(nums,index,right--);
            }else{
                swap(nums,left++,index++);
            }
        }
        return right + 1;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public int removeElement2(int[] nums, int val){
        if (nums==null){
            return -1;
        }
        int index = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
