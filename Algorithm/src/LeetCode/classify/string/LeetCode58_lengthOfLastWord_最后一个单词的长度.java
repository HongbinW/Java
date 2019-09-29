package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2019/9/29
 */
public class LeetCode58_lengthOfLastWord_最后一个单词的长度 {
    // 100%  
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        s = s.trim();
        if (s.lastIndexOf(' ') != -1)
            return s.length() - s.lastIndexOf(' ') - 1;
        else
            return s.length();
    }
}
