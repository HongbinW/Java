package LeetCode.每日一题;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/27
 */
public class LeetCode974_subarraysDivByK_和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int K) {
        int cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int index = 0;
        int res = 0;
        while (index < A.length){
            cur += A[index];
            int c = (cur % K + K) % K;
            int same = map.getOrDefault(c, 0);
            res += same;
            map.put(c,same + 1);
        }
        return res;
    }
}
