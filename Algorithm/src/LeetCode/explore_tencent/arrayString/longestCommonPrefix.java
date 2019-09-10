package LeetCode.explore_tencent.arrayString;

/**
 * @Author: HongbinW
 * @Date: 2019/9/8 16:08
 * @Version 1.0
 * @Description:
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int minIndex = 0;
        for (int i = 1; i < strs.length; i ++){
            if (strs[i].length() < strs[minIndex].length()){
                minIndex = i;
            }
        }
        int index = 0;
        while (index < strs[minIndex].length()){
            for (int i = 0; i < strs.length; i ++){
                if (i == minIndex){
                    continue;
                }
                if (strs[i].charAt(index) != strs[minIndex].charAt(index)){
                    return strs[i].substring(0,index);
                }
            }
            index ++;
        }
        return strs[minIndex].substring(0,index);
    }
}
