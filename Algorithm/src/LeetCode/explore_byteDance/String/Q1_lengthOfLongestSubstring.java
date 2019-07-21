package LeetCode.explore_byteDance.String;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

import java.util.HashSet;

/**
 * @Author: HongbinW
 * @Date: 2019/7/21 22:07
 * @Version 1.0
 * @Description:
 */
public class Q1_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                res = Math.max(right-left,res);
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q1_lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
