package LeetCode.explore_2018Hot;

/**
 * @Author: HongbinW
 * @Date: 2020/1/1 21:12
 * @Version 1.0
 * @Description:
 */
public class merge_合并两个有序数据 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        while (index >= 0 && m > 0 && n > 0){
            if (nums1[m-1] < nums2[n-1]){
                nums1[index] = nums2[n-1];
                n --;
            }else{
                nums1[index] = nums1[m-1];
                m --;
            }
            index --;
        }
        while (m > 0){
            nums1[index] = nums1[m-1];
            m --;
            index --;
        }
        while (n > 0){
            nums1[index] = nums2[n-1];
            n --;
            index --;
        }
    }
}
