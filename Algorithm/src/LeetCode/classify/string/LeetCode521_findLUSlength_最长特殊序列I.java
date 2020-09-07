package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/7
 */
public class LeetCode521_findLUSlength_最长特殊序列I {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return a.length() > b.length() ? a.length() : b.length();
    }
}
