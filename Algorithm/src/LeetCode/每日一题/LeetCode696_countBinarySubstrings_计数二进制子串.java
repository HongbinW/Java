package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/10
 */
public class LeetCode696_countBinarySubstrings_计数二进制子串 {
    public int countBinarySubstrings(String s) {
        char[] chs = s.toCharArray();
        int pre = 0; // 离他最近的符合要求的最大长度
        int res = 0;
        for (int i = 1; i < chs.length; i ++){
            if (chs[i] == chs[i-1]){
                int preIndex = i - 1 - pre;
                if (preIndex >= 0 && chs[preIndex] != chs[i]){
                    res ++;
                    pre += 2;
                }else{
                    pre = 0;
                }
            }else{
                res ++;
                pre = 2;
            }
        }
        return res;
    }
}
