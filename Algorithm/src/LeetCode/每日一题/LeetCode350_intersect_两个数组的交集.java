package LeetCode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/13
 */
public class LeetCode350_intersect_两个数组的交集 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] == nums2[index2]){
                list.add(nums1[index1++]);
                index2 ++;
            }else if (nums1[index1] < nums2[index2]){
                index1 ++;
            }else{
                index2 ++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i ++){
            res[i] = list.get(i);
        }
        return res;
    }
}
