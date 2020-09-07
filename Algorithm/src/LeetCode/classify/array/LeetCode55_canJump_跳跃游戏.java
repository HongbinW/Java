package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 22:52
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/jump-game/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */

/**
 * 思路：记录当前需要跳到的最远距离，看现在这个位置能不能跳过去就可以了
 */
public class LeetCode55_canJump_跳跃游戏 {
    // 10%+ 70%+
    public boolean canJump(int[] nums) {
        boolean[] t = new boolean[nums.length];
        t[nums.length-1] = true;
        for (int i = nums.length - 2; i >= 0; i --){
            for (int j = 0; j <= nums[i] && j < nums.length; j ++){
                if (t[i + j]){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[0];
    }
    // 100% 94%
    public static boolean canJump2(int[] nums){
        int lastPostion = nums.length-1;
        for (int i = nums.length - 2; i >= 0; i --){
            if (nums[i] + i > lastPostion){
                lastPostion = i;
            }
        }
        return lastPostion == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump2(new int[]{3,2,1,0,0,0,0,0,4}));
    }
}
