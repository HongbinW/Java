package LeetCode.explore_tencent.arrayString;

import java.util.HashMap;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
