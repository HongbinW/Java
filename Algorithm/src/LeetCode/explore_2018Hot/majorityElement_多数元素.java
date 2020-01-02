package LeetCode.explore_2018Hot;

/**
 * @Author: HongbinW
 * @Date: 2020/1/1 21:05
 * @Version 1.0
 * @Description:
 */
public class majorityElement_多数元素 {
    public static int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i ++){
            if (result == nums[i]){
                count ++;
            }else {
                count --;
                if (count == 0){
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
