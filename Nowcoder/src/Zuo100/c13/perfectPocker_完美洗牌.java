package Zuo100.c13;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2019/11/14
 */
public class perfectPocker_完美洗牌 {
    // 思路一：找个辅助数组，然后每个位置要变换到的位置都可以算出来
    // 思路二：不用辅助数组，一直做位置变换
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int diff = 0;
        if ((nums.length & 1) == 0){        // 奇数时 i -> (2 * i) % len ； 偶数时 i -> (2 * i) % (len-1) 而且，最后一个数不处理
            len --;
            diff = 1;
        }
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length - diff; i ++){
            tmp[(2*i) % len] = nums[i];
        }
        for (int i = 0; i < nums.length - diff; i ++){
            nums[i] = tmp[i];
        }
    }

}
