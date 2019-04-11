package LeetCode.casuallly;

/**
 * @Author: HongbinW
 * @Date: 2019/4/11 20:16
 * @Version 1.0
 * @Description:
 */
public class LeetCode04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int targetNum = (m + n) / 2;
        if(nums1[0] >= nums2[n-1]){
            return (nums1[0] + nums2[n-1]) / 2;
        }
        else if(nums1[m-1] <= nums2[0]){
            return (nums1[m-1] + nums2[0]) / 2;
        }
        else if(nums1[0] < nums2[n-1] && nums1[0] > nums2[0]){

        }else if(nums1[m-1] > nums2[0] && nums1[m-1] < nums2[n-1]){

        }else{

        }
        return 0;
    }
}
