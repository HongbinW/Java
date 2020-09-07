package LeetCode.casuallly;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/5
 */
// 找最短无序子数组，使得如果将这个子数组排序，能够使整个数组都是升序的
public class LeetCode581_findUnsortedSubarray_最短无序子数组 {
    // 单调栈
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int start = nums.length;
        for (int i = 0; i < nums.length; i ++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                start = Math.min(start, stack.pop());
            }
            stack.push(nums[i]);
        }
        int end = 0;
        stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i --){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                end = Math.max(end, stack.pop());
            }
            stack.push(nums[i]);
        }
        return end > start ? end - start + 1 : 0;
    }

    public int findUnsortedSubarray2(int[] nums) {
        //思路：不要找第一个逆序对，要找最后的逆序对
        if (null == nums) {
            return 0;
        }
        int length = nums.length;
        //标记最后一个逆序
        int l = 0;      // 比最小值大的最开始一个位置
        int r = -1;     // 比最大值小的最后一个位置
        int max = nums[l];
        int min = nums[length - 1];
        //一般地，在没有出现逆序时，最大值和最小值都会一直被更新
        for (int i = 0; i < length; i++) {
            //标记比目前最大值小的值，因为出现了逆序
            if (nums[i] < max) {                // 从前往后
                r = i;
            } else {
                max = nums[i];
            }
            //同理标记比最小值大的值
            if (nums[length - i - 1] > min) {       // 从后往前
                l = length - i - 1;
            } else {
                min = nums[length - i - 1];
            }
        }
        return r - l + 1;
    }
}
