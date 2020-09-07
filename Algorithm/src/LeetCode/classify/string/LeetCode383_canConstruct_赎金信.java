package LeetCode.classify.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/5
 */
public class LeetCode383_canConstruct_赎金信 {
    //复杂度高
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < magazine.length(); i ++){
            if (!map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),0);
            }
            map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
        }
        for (int i = 0; i < ransomNote.length(); i ++){
            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0){
                return false;
            }else {
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            }
        }
        return true;
    }
    //最优解
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() == 0){
            return true;
        }
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        int[] arr = new int[26];
        for (char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c,arr[c - 'a']);
            if (index == -1){
                return false;
            }
            arr[c-'a'] = index + 1;
        }
        return true;
    }
}
