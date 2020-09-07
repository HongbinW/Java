package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/19
 */
public class M57_twoSum_和为s的两个数 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum < target){
                left ++;
            }else if (sum > target){
                right --;
            }else{
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
