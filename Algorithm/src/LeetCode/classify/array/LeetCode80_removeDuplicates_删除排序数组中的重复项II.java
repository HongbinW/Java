package LeetCode.classify.array;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/15
 */
//排序数组，每个数至多出现两次
public class LeetCode80_removeDuplicates_删除排序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int index = 1;
        int fast = 1;
        int cur = nums[0];
        int times = 1;
        while (fast < nums.length){
            if (nums[fast] == cur){
                times ++;
            }else {
                cur = nums[fast];
                times = 1;
            }
            if (times <= 2){
                nums[index++] = nums[fast];
            }
            fast ++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode80_removeDuplicates_删除排序数组中的重复项II().removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
