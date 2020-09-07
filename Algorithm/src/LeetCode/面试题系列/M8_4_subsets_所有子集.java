package LeetCode.面试题系列;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */
public class M8_4_subsets_所有子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        process(res,new ArrayList<Integer>(), nums, 0);
        return res;
    }
    public void process(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        if (start == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[start]);
        process(res,list,nums,start+1);
        list.remove(list.size()-1);
        process(res,list,nums,start+1);
    }

}
