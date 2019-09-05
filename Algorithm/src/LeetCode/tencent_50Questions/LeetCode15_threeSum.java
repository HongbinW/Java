package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/2 14:26
 * @Version 1.0
 * @Description:
 */
public class LeetCode15_threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                if (nums[left] + nums[right] == -nums[i]){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left ++;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }else if (nums[left] + nums[right] > -nums[i]){
                    right --;
                }else{
                    left ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{0,0,0,0});
        for (List<Integer> ele : res){
            for (int i : ele){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
