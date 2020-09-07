package JZOFFER2;

import java.util.HashSet;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q48_lengthOfLongestSubstring_最长不含重复字符的子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        char[] chs = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        while (right < chs.length){
            if (!set.contains(chs[right])){
                res = Math.max(res,right-left+1);
                set.add(chs[right++]);
            }else{
                while (chs[left] != chs[right]){
                    set.remove(chs[left++]);
                }
                left++;
                right++;
            }
        }
        return res;
    }
}
