package LeetCode.会员.大疆;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/16
 */
public class LeetCode7_reverse_数字反转 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
