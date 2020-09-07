package LeetCode.每日一题;

import java.util.HashMap;

/**
 * Description
 * Author  HongbinW
 * Date 2020/5/23
 */
public class LeetCode76_minWindow_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int count = 0;
        char[] ts = t.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < ts.length; i ++){
            if (!map.containsKey(ts[i])){
                map.put(ts[i],1);
                count ++;
            }else{
                map.put(ts[i],map.get(ts[i])+1);
            }
        }
        char[] ss = s.toCharArray();
        int minLeft = 0;
        int minRight = ss.length + 1;
        while(left < ss.length && right <= ss.length){
            if (count > 0 && right < ss.length){
                if(map.containsKey(ss[right])){
                    int cur = map.get(ss[right]);
                    map.put(ss[right],cur-1);
                    if (cur - 1 == 0){
                        count --;
                    }
                }
                right ++;
            }else if (count == 0){
                if (map.containsKey(ss[left])){
                    int cur = map.get(ss[left]);
                    if (cur < 0){
                        cur ++;
                        map.put(ss[left],cur);
                        left ++;
                    }else if(right - left < minRight - minLeft){
                        minRight = right;
                        minLeft = left;
                        map.put(ss[left],cur+1);
                        left ++;
                        count ++;
                    }else{
                        map.put(ss[left],cur+1);
                        left ++;
                        count ++;
                    }
                }else{
                    left++;
                }
            }else{
                right ++;
            }
        }
        return minRight - minLeft > ss.length ? "" : s.substring(minLeft,minRight);
    }
}
