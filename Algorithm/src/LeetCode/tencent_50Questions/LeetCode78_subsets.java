package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/2 11:00
 * @Version 1.0
 * @Description:
 */
public class LeetCode78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        for (int i = 0 ; i < nums.length; i ++) {
            int size = res.size();
            for (int j = 0; j < size; j ++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> res = new LeetCode78_subsets().subsets(arr);
        for (List<Integer> ele : res){
            for (int i : ele){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
