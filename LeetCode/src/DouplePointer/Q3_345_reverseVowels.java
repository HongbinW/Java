package DouplePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: HongbinW
 * @Date: 2019/4/4 15:30
 * @Version 1.0
 * @Description:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class Q3_345_reverseVowels {
    //只是用于查找，用哈希表更为高效
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char[] c = new char[s.length()];
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1 <= p2){
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);
            if(!vowels.contains(c1))
                c[p1++] = c1;
            else if(!vowels.contains(c2))
                c[p2--] = c2;
            else{
                c[p1++] = c2;
                c[p2--] = c1;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        Q3_345_reverseVowels q = new Q3_345_reverseVowels();
        System.out.println(q.reverseVowels("leetcode"));
    }
}
