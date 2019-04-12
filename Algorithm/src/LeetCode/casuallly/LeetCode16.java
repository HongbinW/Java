package LeetCode.casuallly;

import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/4/12 16:12
 * @Version 1.0
 * @Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int c = Math.abs(target - res);
        for (int i = 0; i < nums.length - 2;i ++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1,r = nums.length-1;
            while(l < r){
                int curSum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - curSum) < c){
                    c = Math.abs(target - curSum);
                    res = curSum;
                }
                if(curSum > target){
                    r--;
                }else if(curSum < target){
                    l++;
                }else{
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,1,-3};
        System.out.println(new LeetCode16().threeSumClosest(arr,1));
    }
}
