package LeetCode.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/23 22:38
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 */

/**
 * 思路：多加个排序（因为有重复数字），DFS
 */
public class LeetCode40_combinationSum2_和为target的组合 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        process(candidates,0,target,0);
        return res;
    }

    public void process(int[] candidates, int curSum, int target, int start){
        if (curSum == target){
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i ++){
            if (i != start && candidates[i] == candidates[i-1]){
                continue;
            }
            if (target - curSum - candidates[i] >= 0){
                list.add(candidates[i]);
                process(candidates,curSum + candidates[i],target,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
