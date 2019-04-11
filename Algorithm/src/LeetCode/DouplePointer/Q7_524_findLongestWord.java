package DouplePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2019/4/4 16:49
 * @Version 1.0
 * @Description: Given a string and a string dictionary, find the longest string in the dictionary
 * that can be formed by deleting some characters of the given string. If there are more than one
 * possible results, return the longest word with the smallest lexicographical order. If there is no
 * possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class Q7_524_findLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String target = "";
        for(String str : d){
            if(str.length() < target.length()||
                     (str.length() == target.length() && target.compareTo(str) < 0)) //他说按字典顺序指的是，按字母顺序
                continue;
            if(isvalid(s,str)){
                target = str;
            }
        }
        return target;

    }
    public boolean isvalid(String s,String con){
        int ps = 0,pcon = 0;
        while(ps < s.length() && pcon < con.length()){
            if(s.charAt(ps) == con.charAt(pcon)){
                ps++;
                pcon++;
            }
            else
                ps++;
        }
        return pcon == con.length();
    }
}
