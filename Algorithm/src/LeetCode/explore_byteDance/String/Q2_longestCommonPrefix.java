package LeetCode.explore_byteDance.String;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
/**
 * @Author: HongbinW
 * @Date: 2019/7/21 22:23
 * @Version 1.0
 * @Description:
 */
public class Q2_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String minString = strs[0];
        //找到最短字符串
        for (String str : strs){
            if(minString.length() > str.length()){
                minString = str;
            }
        }
        boolean flag = true;
        while (flag){
            int count = 0;
            for (int i = 0 ; i < strs.length; i ++){
                if(strs[i].indexOf(minString) != 0){
                    minString = minString.substring(0,minString.length()-1);
                    break;
                }
                count ++;
            }
            if (count == strs.length || minString.equals("")){
                flag = false;
            }
        }
        return minString;
    }

    public static void main(String[] args) {
        System.out.println(new Q2_longestCommonPrefix().longestCommonPrefix(new String[]{"dog","og"}));
    }
}
