package LeetCode.classify.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/9/24 21:16
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/first-missing-positive/
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 */
public class LeetCode41_firstMissingPositive_缺失的第一个正数 {
    //26% 86%
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] <= 0){
                continue;
            }
            queue.offer(nums[i]);
        }
        int index = 1;
        while (!queue.isEmpty()){
            if (index < queue.peek()){
                return index;
            }else if (index == queue.poll()){
                index ++;
            }
        }
        return index;
    }
    //99% 86%
    public int firstMissingPositive2(int[] nums) {

        for (int i = 0; i < nums.length;) {
            if (nums[i] <= nums.length && nums[i] >= 1 && nums[i] != i + 1 && nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        int i = 0;
        while (i < nums.length && i + 1 == nums[i])
            i++;
        return i + 1;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode41_firstMissingPositive_缺失的第一个正数().firstMissingPositive2(new int[]{3,4,-1,1}));
    }
}
