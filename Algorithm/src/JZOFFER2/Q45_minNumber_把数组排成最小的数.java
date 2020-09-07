package JZOFFER2;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q45_minNumber_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i ++){
            strs[i] = String.valueOf(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs,(o1,o2)->(o1+o2).compareTo(o2+o1));
        for (int i = 0; i < strs.length; i ++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
