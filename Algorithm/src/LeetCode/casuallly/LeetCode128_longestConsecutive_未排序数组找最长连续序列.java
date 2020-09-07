package LeetCode.casuallly;

import java.util.HashSet;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/7
 */
public class LeetCode128_longestConsecutive_未排序数组找最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i ++){
            if (set.contains(nums[i]-1)){
                continue;
            }
            int count = 0;
            int cur = nums[i];
            while (set.contains(cur)){
                count ++;
                cur ++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
