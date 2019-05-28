package LeetCode.tencent_50Questions;

public class LeetCode238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        int[] arrL = new int[nums.length];
        int[] arrR = new int[nums.length];
        arrL[0] = 1;
        for(int i = 1; i < nums.length; i++){
            arrL[i] = arrL[i-1] * nums[i-1];
        }
        arrR[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            arrR[i] = arrR[i+1] * nums[i+1];
        }
        for(int i = 0; i < nums.length; i++){
            arrL[i] = arrL[i] * arrR[i];
        }
        return arrL;
    }
}
