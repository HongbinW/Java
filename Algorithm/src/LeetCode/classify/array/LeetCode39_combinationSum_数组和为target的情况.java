package LeetCode.classify.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 22:25
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明:
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 */

/**
 * 思路：递归，深度优先遍历
 * 去重依靠每次循环的起始位置
 */
public class LeetCode39_combinationSum_数组和为target的情况 {
    // 99.92%  96.85%
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0){
            return res;
        }
        process(candidates,0,target,0);
        return res;
    }

    public void process(int[] candidates, int curSum, int target, int start){
        if (curSum == target){
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i ++){
            if (target - curSum - candidates[i] >= 0){
                list.add(candidates[i]);
                process(candidates,curSum + candidates[i],target,i);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode39_combinationSum_数组和为target的情况().combinationSum(new int[]{2,3,6,7},7);
    }
}
