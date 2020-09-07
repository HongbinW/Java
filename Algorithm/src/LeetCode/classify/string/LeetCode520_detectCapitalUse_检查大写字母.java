package LeetCode.classify.string;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/7
 */
public class LeetCode520_detectCapitalUse_检查大写字母 {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0){
            return true;
        }
        String lower = word.toLowerCase();
        if (word == lower){
            return true;
        }else if (word == word.toUpperCase()){
            return true;
        }else if (((char)(lower.charAt(0) - 32) + lower.substring(1)).equals(word)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "Leetcode";
        String lower = s.toLowerCase();
        System.out.println((char)(lower.charAt(0) - 32) + lower.substring(1));
        System.out.println(new LeetCode520_detectCapitalUse_检查大写字母().detectCapitalUse(s));
    }
}
