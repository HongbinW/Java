package LeetCode.classify.array;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/15
 */
public class LeetCode81_search_搜索旋转排序数组II {
    public static void main(String[] args) {
        System.out.println(new LeetCode81_search_搜索旋转排序数组II().search(new int[]{1,1,1,1,1,2,1,1,1},2));
    }
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[left] == target || nums[right] == target || nums[mid] == target){
                return true;
            }
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right --;
            }
        }
        if (target >= nums[left] && target <= nums[nums.length-1]){
            return midSearch(nums,left,nums.length-1,target);
        }else if (left > 0 && target >= nums[0] && target <= nums[left-1]){
            return midSearch(nums,0,left-1,target);
        }
        return false;
    }
    public boolean midSearch(int[] nums, int left, int right, int target){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[left] == target || nums[right] == target || nums[mid] == target){
                return true;
            }
            if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
