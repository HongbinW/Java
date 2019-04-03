package hashTable;

import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @Author: HongbinW
 * @Date: 2019/4/2 14:53
 * @Version 1.0
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0 ; i < s.length(); i++){
            if(freq[s.charAt(i)- 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode387 l = new LeetCode387();
        System.out.println(l.firstUniqChar("dddccdbba"));
    }
}
