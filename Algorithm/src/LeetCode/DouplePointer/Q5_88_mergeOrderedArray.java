package DouplePointer;

/**
 * @Author: HongbinW
 * @Date: 2019/4/4 15:53
 * @Version 1.0
 * @Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Q5_88_mergeOrderedArray {
    //耗费空间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;  //nums1的指针
        int j = 0;  //nums2的指针
        int[] res = new int[m+n+1];
        int r = 0;  //res的指针
        while(i < m && j < n){
            res[r++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < m){
            res[r++] = nums1[i++];
        }
        while(j < n){
            res[r++] = nums2[j++];
        }
        for(int p = 0; p < m+n; p++){
            nums1[p] = res[p];
        }
    }
    //不用额外空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, end = nums1.length - 1;
        while(i >= 0 && j >= 0){
            nums1[end--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(i >= 0){
            nums1[end--] = nums1[i--];
        }
        while(j >= 0){
            nums1[end--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        Q5_88_mergeOrderedArray q = new Q5_88_mergeOrderedArray();
        q.merge2(nums1,0,nums2,1);
    }
}
