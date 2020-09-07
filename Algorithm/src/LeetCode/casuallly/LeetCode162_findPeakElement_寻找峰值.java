package LeetCode.casuallly;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/7
 */
public class LeetCode162_findPeakElement_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid+1]){   // 看他处在哪个阶段（上升or下降）
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
