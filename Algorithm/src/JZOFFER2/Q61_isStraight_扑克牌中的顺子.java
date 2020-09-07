package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/7/4
 */
public class Q61_isStraight_扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        int[] arr = new int[14];
        for (int i = 0; i < nums.length; i ++){
            arr[nums[i]] ++;
        }
        int index = 1;
        while (arr[index] == 0){
            index ++;
        }
        int count = 1;
        index ++;
        while (count < 5 && index < 14){
            if (arr[index] == 0) {
                if (arr[0] > 0) {
                    arr[0] --;
                } else {
                    return false;
                }
            }
            count ++;
            index ++;
        }
        return 5 - count <= nums[0];
    }
}
