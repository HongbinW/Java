package LeetCode.会员.拼多多;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/2
 */
public class LeetCode945_minIncrementForUnique_使数组唯一的最小增量 {
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i-1]) {
                count += A[i-1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return count;
    }
}
