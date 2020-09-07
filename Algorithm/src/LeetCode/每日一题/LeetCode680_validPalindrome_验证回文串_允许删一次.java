package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/19
 */
public class LeetCode680_validPalindrome_验证回文串_允许删一次 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] chs = s.toCharArray();
        while(left < right){
            if(chs[left] != chs[right]){
                return process(chs,left+1,right) || process(chs,left,right-1);
            }
            left ++;
            right --;
        }
        return true;
    }
    public boolean process(char[] chs, int left, int right){
        while(left < right){
            if(chs[left] != chs[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
