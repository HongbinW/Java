package LeetCode.casuallly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: HongbinW
 * @Date: 2019/4/11 17:38
 * @Version 1.0
 * @Description:
 */
public class LeetCode03 {
    //暴力法
    public static int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            ArrayList list = new ArrayList();
            for(int j = i; j < s.length();j++) {
                if (list.isEmpty()) {
                    list.add(s.charAt(j));
                } else {
                    if (list.contains(s.charAt(j))) {
                        break;
                    } else {
                        list.add(s.charAt(j));
                    }
                }
            }
            maxlen = maxlen < list.size() ? list.size() : maxlen;
            if(maxlen > s.length() - i)
                return maxlen;
        }
        return maxlen;
    }
    //滑动窗口
    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        char[] chs = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < chs.length){
            if (map.containsKey(chs[right])){
                res = Math.max(res, right - left);
                left = Math.max(left,map.get(chs[right]) + 1);
            }
            map.put(chs[right],right++);
        }
        return Math.max(res,right-left);
    }
}
