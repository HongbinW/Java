package LeetCode.tencent_50Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/9/3 11:44
 * @Version 1.0
 * @Description:
 */
public class LeetCode46_permute {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        process(nums,0);
        return res;
    }
    private void process(int[] nums, int start){
        if (start == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i ++){
                list.add(nums[i]);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i ++){
            swap(nums,start,i);
            process(nums,start+1);
            swap(nums,start,i);
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new LeetCode46_permute().permute(new int[]{1,2,3});
        for (List<Integer> ele : res){
            for (int i : ele){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
