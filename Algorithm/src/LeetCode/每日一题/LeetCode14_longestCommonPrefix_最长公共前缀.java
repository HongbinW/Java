package LeetCode.每日一题;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/15
 */
public class LeetCode14_longestCommonPrefix_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].length() == 0){
            return "";
        }
        int index = 0;
        boolean flag = true;
        while(index < strs[0].length()){
            char c = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i ++){
                if (index >= strs[i].length()){
                    flag = false;
                    break;
                }else if (strs[i].charAt(index) != c){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                break;
            }
            index ++;
        }
        return strs[0].substring(0,index);
    }
}
