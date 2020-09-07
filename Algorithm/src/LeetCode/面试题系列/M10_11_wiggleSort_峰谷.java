package LeetCode.面试题系列;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M10_11_wiggleSort_峰谷 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int diff = 0;
        if ((nums.length & 1) == 0){
            len --;
            diff = 1;
        }
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length - diff; i ++){
            tmp[(2*i) % len] = nums[i];
        }
        for (int i = 0; i < nums.length - diff; i ++){
            nums[i] = tmp[i];
        }
    }
}
