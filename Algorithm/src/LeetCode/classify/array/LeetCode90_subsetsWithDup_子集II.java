package LeetCode.classify.array;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/15
 */
public class LeetCode90_subsetsWithDup_子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i ++){
            int len = res.size();
            for (int j = 0; j < len; j ++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                int hash = temp.hashCode();
                if (!set.contains(hash)){
                    set.add(hash);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list2.add(4);
        list2.add(1);
        set.add(list1);
        set.add(list2);
        System.out.println(set.size());
    }
}
