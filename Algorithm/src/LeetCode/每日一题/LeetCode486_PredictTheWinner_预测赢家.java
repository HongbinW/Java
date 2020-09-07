package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/9/1
 */
public class LeetCode486_PredictTheWinner_预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        return first(nums,0,nums.length-1) >= second(nums, 0, nums.length - 1);
    }
    public int first(int[] nums, int start, int end){
        if(start > end){
            return 0;
        } else if (start == end){
            return nums[start];
        }
        return Math.max(nums[start] + second(nums,start+1,end), nums[end] + second(nums,start,end-1));
    }
    public int second(int[] nums, int start, int end){
        if (start >= end){
            return 0;
        }
        return Math.min(first(nums,start+1,end), first(nums,start,end-1));
    }
}
