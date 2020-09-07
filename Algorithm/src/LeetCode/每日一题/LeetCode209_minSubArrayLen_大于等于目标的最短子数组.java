package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/28
 */
public class LeetCode209_minSubArrayLen_大于等于目标的最短子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int cur = 0;
        int res = nums.length + 1;
        while(right < nums.length && left < nums.length){
            if(cur < s){
                cur += nums[right++];
            }else{
                res = Math.min(res, right - left);
                cur -= nums[left++];
            }
        }
        while (cur >= s && left < nums.length){
            res = Math.min(res, right - left);
            cur -= nums[left++];
        }
        return res > nums.length ? 0 : res;
    }
}
