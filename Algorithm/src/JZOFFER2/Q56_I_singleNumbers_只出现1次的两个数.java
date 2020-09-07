package JZOFFER2;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/7
 */
public class Q56_I_singleNumbers_只出现1次的两个数 {
    public int[] singleNumbers(int[] nums) {
        int stand = 0;
        for (int i : nums){
            stand ^= i;
        }
        int index = 1;
        while ((stand & index) == 0){
            index <<= 1;
        }
        int[] res = new int[2];
        for (int i : nums){
            if ((i & index) == 0){
                res[0] ^= i;
            }else{
                res[1] ^= i;
            }
        }
        return res;
    }
}
