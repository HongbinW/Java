package LeetCode.classify.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2019/9/29
 * https://leetcode-cn.com/problems/group-anagrams/
 */

/**
 * 每次将字符串变为char[]，排序后比较，放入map，最后再一起放入list
 */
public class LeetCode49_groupAnagrams_字母异位词分组 {
    //95% 88%
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i ++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String t = new String(temp);
            if (map.containsKey(t)){
                map.get(t).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(t,list);
            }
        }
        for (List<String> ele : map.values()){
            res.add(ele);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
