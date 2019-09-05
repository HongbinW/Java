package LeetCode.tencent_50Questions;

import java.util.PriorityQueue;

/**
 * @Author: HongbinW
 * @Date: 2019/8/30 17:16
 * @Version 1.0
 * @Description:
 */
public class LeetCode4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0){
            if (nums2.length % 2 == 0){
                return (nums2[nums2.length/2] + nums2[nums2.length/2 - 1])/2.0;
            }else{
                return nums2[nums2.length/2];
            }
        }else if (nums2 == null || nums1.length == 0){
            if (nums1.length % 2 == 0){
                return (nums1[nums1.length/2] + nums1[nums1.length/2 - 1])/2.0;
            }else{
                return nums1[nums1.length/2];
            }
        }
        PriorityQueue<Integer> bigNumber = new PriorityQueue<>();
        PriorityQueue<Integer> smallNumber = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0 ; i < nums1.length; i ++){
            bigNumber.add(nums1[i]);
        }
        for (int i = 0 ; i < nums2.length; i ++){
            bigNumber.add(nums2[i]);
        }
        while (bigNumber.size() - smallNumber.size() >= 2){
            smallNumber.add(bigNumber.poll());
        }
        if (Math.abs(bigNumber.size() - smallNumber.size()) > 0){
            return bigNumber.poll();
        }else{
            return (bigNumber.poll() + smallNumber.poll()) / 2.0;
        }
    }

    class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3};
        int[] arr2 = new int[]{1};
    }
}
