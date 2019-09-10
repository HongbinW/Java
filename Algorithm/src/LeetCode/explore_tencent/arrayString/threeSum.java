package LeetCode.explore_tencent.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 16:14
 * @Version 1.0
 * @Description:
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }else{
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length-1;
                while (left < right){
                    if (left > i + 1 && nums[left] == nums[left - 1]){
                        left ++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]){
                        right --;
                        continue;
                    }
                    if (nums[left] + nums[right] > target){
                        right --;
                    }else if (nums[left] + nums[right] < target){
                        left ++;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left ++;
                    }
                }
            }
        }
        return res;
    }
}
