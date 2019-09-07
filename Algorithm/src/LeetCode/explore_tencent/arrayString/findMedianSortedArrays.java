package LeetCode.explore_tencent.arrayString;

/**
 * @Author: HongbinW
 * @Date: 2019/9/6 22:35
 * @Version 1.0
 * @Description:
 */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int half = (m + n + 1) / 2;
        int iMin = 0, iMax = m;
        while (iMin <= iMax){
            int i = (iMax + iMin) / 2;
            int j = half - i;
            if (i < iMax && nums1[i] < nums2[j-1]){
                iMin = i + 1;
            }else if (i > iMin && nums1[i-1] > nums2[j]){
                iMax = i - 1;
            }
            else{
                int maxLeft = 0;
                if (i == 0){
                    maxLeft = nums2[j-1];
                }else if (j == 0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if ((m + n) % 2 == 1){
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m){
                    minRight = nums2[j];
                }else if (j == n){
                    minRight = nums1[i];
                }else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }

                return (minRight + maxLeft) / 2.0;
            }
        }
        return 0.0;
    }
}
