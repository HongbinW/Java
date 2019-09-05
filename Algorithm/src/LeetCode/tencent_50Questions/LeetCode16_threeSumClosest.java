package LeetCode.tencent_50Questions;

import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/9/2 14:39
 * @Version 1.0
 * @Description:
 */
public class LeetCode16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1,right = nums.length-1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target-temp) < diff){
                    res = temp;
                }
                if (temp < target){
                    left ++;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
