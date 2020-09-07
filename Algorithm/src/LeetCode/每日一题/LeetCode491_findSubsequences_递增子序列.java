package LeetCode.每日一题;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/25
 */
public class LeetCode491_findSubsequences_递增子序列 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, -1, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int idx, List<Integer> curList) {
        // 只要当前的递增序列长度大于 1，就加入到结果 res 中，然后继续搜索递增序列的下一个值。
        if (curList.size() > 1) {
            res.add(new ArrayList<>(curList));
        }
        // set只管从当前位置开始的值
        Set<Integer> set = new HashSet<>();
        for (int i = idx + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (idx == -1 || nums[i] >= nums[idx]) {
                curList.add(nums[i]);
                dfs(nums, i, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
