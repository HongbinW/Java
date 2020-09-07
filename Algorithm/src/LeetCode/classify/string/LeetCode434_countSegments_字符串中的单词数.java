package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/5
 */
public class LeetCode434_countSegments_字符串中的单词数 {
    public int countSegments(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        s = s.trim();
        String[] strs = s.split(" ");
        int count = 0;
        for (int i = 0; i < strs.length; i ++){
            if (strs[i].length() != 0){
                count ++;
            }
        }
        return count;
    }
}
