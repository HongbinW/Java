package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/25 16:26
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/jump-game-ii/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */

/**
 * 思路：贪婪
 * 每次找当前能跳到的最远位置，当i = end时，更新end = maxPostion，steps++
 */
public class LeetCode45_jumpII_跳跃游戏 {
    // 92%   94%
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i ++){ //最后一个不用跳了
            maxPosition = Math.max(maxPosition,i + nums[i]);
            if (i == end){              //即使实际跳的不是end，那也是在end和preEnd之间的，所以需要+1次，而MaxPostion是实时更新的
                end = maxPosition;
                steps ++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode45_jumpII_跳跃游戏().jump(new int[]{2,3,1,1,4}));
    }
}