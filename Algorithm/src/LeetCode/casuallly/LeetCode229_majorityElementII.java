package LeetCode.casuallly;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/6 21:18
 * @Version 1.0
 * @Description:
 */
public class LeetCode229_majorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return list;
        }
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for (int i = 0; i < nums.length; i ++){
            if (count1 == 0 && candidate2 != nums[i]){
                count1 = 1;
                candidate1 = nums[i];
            }else if (count2 == 0 && candidate1 != nums[i]){
                count2 = 1;
                candidate2 = nums[i];
            }else if (candidate1 == nums[i]){
                count1 ++;
            }else if (candidate2 == nums[i]){
                count2 ++;
            }else{
                count1 --;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums){
            if (i == candidate1){
                count1++;
            }
            if (i == candidate2){
                count2 ++;
            }
        }
        if (count1 > nums.length / 3){
            list.add(candidate1);
        }
        if (count2 > nums.length / 3 && candidate1 != candidate2){
            list.add(candidate2);
        }
        return list;
    }
}
