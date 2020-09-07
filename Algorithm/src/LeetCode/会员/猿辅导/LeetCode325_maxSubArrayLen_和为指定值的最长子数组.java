package LeetCode.会员.猿辅导;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/25
 */
public class LeetCode325_maxSubArrayLen_和为指定值的最长子数组 {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int cur = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i ++){
            cur += nums[i];
            if (map.containsKey(cur - k)){
                res = Math.max(res, i - map.get(cur-k));
            }
            if (!map.containsKey(cur)){
                map.put(cur,i);
            }
        }
        return res;
    }
}
