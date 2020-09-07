package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/24
 */
/**
 * 关于数组位置和个数的思考：
 * 通过位置计算个数时，比如end - start + 1才是个数，比如0,1,2，那么2-0+1=3 才是个数
 * 通过个数计算位置时，比如从start开始的第k个，那么应该是start + k - 1，比如0,1,2,3，找第二个，应该是0+2-1=1，才是第二个
 */
public class LeetCode4_findMedianSortedArrays_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        System.out.println(new LeetCode4_findMedianSortedArrays_寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1,2,3,4},new int[]{5,6,7,8,9,10,11,12,13,14}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。比如len1=3,len2=10,应该找第7大的数，m+n+1 / 2 = 7, m+n+2 / 2 = 7
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1)); // 核心在于找第k小的数
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
