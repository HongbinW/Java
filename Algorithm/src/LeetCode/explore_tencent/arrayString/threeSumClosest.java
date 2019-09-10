package LeetCode.explore_tencent.arrayString;

import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 16:21
 * @Version 1.0
 * @Description:
 */
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(res - target);
        for (int i = 0 ; i < nums.length; i ++){
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp > target){
                    right --;
                    if (Math.abs(temp - target) < minDiff){
                        minDiff = Math.abs(target - temp);
                        res = temp;
                    }
                }else{
                    left++;
                    if (Math.abs(target - temp) < minDiff){
                        minDiff = Math.abs(target - temp);
                        res = temp;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new threeSumClosest().threeSumClosest(new int[]{0,2,1,-3},1));
    }
}
