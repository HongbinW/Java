package DouplePointer;

/**
 * @Author: HongbinW
 * @Date: 2019/4/4 15:42
 * @Version 1.0
 * @Description:
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
public class Q4_680_validPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);  //删除一个，删除后剩下比较直接返回
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q4_680_validPalindromeII q = new Q4_680_validPalindromeII();
        System.out.println(q.validPalindrome("abcba"));
    }
}
