package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/4
 */
public class LeetCode238_productExceptSelf_productExceptSelf_除自身以外数据乘积 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = 1;
        int[] right = new int[len];
        right[len-1] = 1;
        for (int i = 1; i < len; i ++){
            left[i] = left[i-1] * nums[i-1];
            right[len-1-i] = right[len-i] * nums[len-i];
        }
        for (int i = 0; i < len; i ++){
            left[i] *= right[i];
        }
        return left;
    }
}
