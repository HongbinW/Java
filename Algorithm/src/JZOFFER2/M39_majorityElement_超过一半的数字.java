package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/20
 */
public class M39_majorityElement_超过一半的数字 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if(nums[i] == cur){
                count ++;
            }else{
                count --;
                if (count == 0){
                    cur = nums[i];
                    count = 1;
                }
            }
        }
        return cur;
    }
}
