package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/26 22:26
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/sort-colors/
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */

/**
 * 思路：partition
 */
public class LeetCode75_sortColors_颜色分类 {
    // 100% 36.15%
    public void sortColors(int[] nums) {
        int less = 0;
        int more = nums.length - 1;
        int index = 0;
        while (index < more){
            if (nums[index] == 0){
                swap(nums,index++,less++);
            }else if (nums[index] == 1){
                index ++;
            }else{
                swap(nums,index,more--);
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
