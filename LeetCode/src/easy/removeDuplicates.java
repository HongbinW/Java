package easy;

/**
 * Description
 * Author  HongbinW
 * Date 2019/1/25
 */

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class removeDuplicates {
    //My Solution1 260ms
    public int removeDuplicates(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - 1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }

            }
        }
        int n = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[n++] = nums[i];
            }
        }
        return n;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //My Solution 74ms
    public int removeDuplicates1(int[] nums) {
        int n = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < n ; j++){
                if(nums[i] != nums[j])
                    nums[n] = nums[i];
                else
                    break;
            }
        }
        return n;
    }
}
