package LeetCode.explore_2018Hot;

/**
 * @Author: HongbinW
 * @Date: 2020/1/1 21:01
 * @Version 1.0
 * @Description:
 */
public class singleNumber_只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i ++){
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
}
