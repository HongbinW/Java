package dp.dynamic_programming_GK;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: HongbinW
 * @Date: 2019/4/13 20:54
 * @Version 1.0
 * @Description: LeetCode300
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 *
 */
public class Q9_LeetCode300_longestIncreasingSequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] DP = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            DP[i] = 1;
        }
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    DP[i] = Math.max(DP[i],DP[j]) + 1;
                }
            }
            res = Math.max(res,DP[i]);
        }
        return res;
    }
    //法二：
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                searchBinary(list,nums[i]);
            }
        }
        return list.size();
    }
    public void searchBinary(ArrayList<Integer> list,int target){
        int l = 0,r = list.size()-1;
        int[] arr = new int[2];
        Arrays.binarySearch(arr,target);
        while(l < r){
            int mid = l + (r-l)/2;
            if(list.get(mid) < target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        list.set(l,target);
    }
}
