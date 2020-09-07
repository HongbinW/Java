package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/17
 */
public class LeetCode35_searchInsert_搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }
    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]){
            return 0;
        }else if (target > nums[nums.length-1]){
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                return mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
