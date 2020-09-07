package LeetCode.面试题系列;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/28
 */

// OJ没过
public class M8_13_pileBox_堆箱子 {
    public int pileBox(int[][] box) {
        if (box.length == 0){
            return 0;
        }
        Arrays.sort(box, (o1,o2)-> o1[1] != o2[1] ? (o1[2] == o2[2] ? o1[0] - o2[0] : o1[2] - o2[2]) : (o1[2] == o2[2] ? o1[0] - o2[0] : o1[2] - o2[2]));
        int[] dp = new int[box.length];
        dp[0] = box[0][2];
        int res = box[0][2];
        for (int i = 1; i < box.length; i ++){
            for (int j = i - 1; j >= 0; j --){
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]){
                    dp[i] = Math.max(dp[i],dp[j]+box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
