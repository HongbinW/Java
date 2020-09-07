package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/12
 */
public class LeetCode15_threeSum_三数之和 {
    public static void main(String[] args) {
        int[] arr = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> res = threeSum(arr);
        for (List<Integer> list : res){
            for (int i = 0; i < list.size(); i ++){
                System.out.printf("%d ", list.get(i));
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
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
