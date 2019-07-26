package LeetCode.explore_byteDance.ArrayAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
public class Q1_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i < nums.length-2; i ++){
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] != nums[i-1]){
                int left = i + 1;
                int right = nums.length-1;
                int curSum = 0 - nums[i];
                while (left < right){
                    if (nums[left] + nums[right] == curSum){
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] > curSum){
                        right --;
                    }else{
                        left ++;
                    }
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        List<List<Integer>> res = new Q1_threeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> ele : res){
            for (int i : ele){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
