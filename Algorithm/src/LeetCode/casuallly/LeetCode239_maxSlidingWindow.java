package LeetCode.casuallly;

import java.util.LinkedList;

/**
 * @Author: HongbinW
 * @Date: 2019/9/9 23:13
 * @Version 1.0
 * @Description:
 */
public class LeetCode239_maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if(nums == null || nums.length == 0 || nums.length < k){
            return new int[nums.length];
        }
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0 ; i < nums.length; i ++){
            if (list.size() == 0){
                list.addLast(i);
            }else if (nums[list.peekLast()] < nums[i]){
                while (list.size() != 0 && nums[list.peekLast()] < nums[i]){
                    list.pollLast();
                }
                list.addLast(i);
            }else{
                list.addLast(i);
            }
            if (list.peekFirst() == i - k){
                list.pollFirst();
            }
            if (i >= k - 1){
                res[index++] = nums[list.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(arr,3);
    }
}
