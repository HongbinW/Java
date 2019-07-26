package LeetCode.explore_byteDance.ArrayAndSort;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Q3_search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) >>> 1;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                if(target > nums[right]){
                    right = mid-1;
                }else if (target < nums[right]){
                    left = mid+1;
                }else{
                    return right;
                }
            }else{
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new Q3_search().search(new int[]{4,5,6,7,0,1,2},4));
    }
}
