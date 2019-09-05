package LeetCode.tencent_50Questions;

/**
 * @Author: HongbinW
 * @Date: 2019/9/2 11:29
 * @Version 1.0
 * @Description:
 */
public class LeetCode5_longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        while (len > 0) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String temp = s.substring(i, len + i);
                if (isPalindrome(temp)) {
                    return temp;
                }
            }
            len --;
        }
        return "";
    }
    public boolean isPalindrome(String s){
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i ++){
            if (chs[i] != chs[s.length()-1-i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5_longestPalindrome().longestPalindrome("babad"));
    }
}
