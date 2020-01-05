package LeetCode.explore_2018Hot.string;

/**
 * @Author: HongbinW
 * @Date: 2020/1/4 11:40
 * @Version 1.0
 * @Description:
 */
public class isPalindrome_验证回文串 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right){
            while (left < right && !isValid(s.charAt(left))){
                left ++;
            }
            while (left < right && !isValid(s.charAt(right))){
                right --;
            }
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    public boolean isValid(char c){
        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
}
