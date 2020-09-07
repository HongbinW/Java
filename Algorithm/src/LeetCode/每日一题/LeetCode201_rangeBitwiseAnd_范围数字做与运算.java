package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/23
 */
public class LeetCode201_rangeBitwiseAnd_范围数字做与运算 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n){
            m = m >> 1;
            n = n >> 1;
            shift ++;
        }
        return m << shift;
    }
}
