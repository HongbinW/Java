package LeetCode.casuallly;

import java.util.ArrayList;
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
    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int i = 0;
        int j = 0;
        HashSet set = new HashSet();
        while(i < s.length() && j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res,j-i);
            }else{
                set.remove(s.charAt(i++));  //直至移除到跟s.charAt(j)相同的字符为止
            }
        }
        return res;
    }

}
