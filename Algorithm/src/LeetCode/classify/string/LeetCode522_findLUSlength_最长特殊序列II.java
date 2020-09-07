package LeetCode.classify.string;

import java.util.Arrays;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/7
 */
public class LeetCode522_findLUSlength_最长特殊序列II {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,(a,b)-> b.length() - a.length());
        boolean[] arr = new boolean[strs.length];
        for (int i = 0; i < strs.length; i ++){
            if (!arr[i] && isValid(strs,i) && isUniq(strs,i,arr)){
                return strs[i].length();
            }
        }
        return -1;
    }
    public boolean isUniq(String[] strs, int i, boolean[] arr){
        int len = strs[i].length();
        int index = i-1;
        while (index >= 0 && strs[index].length() == len){
            if (strs[index].equals(strs[i])){
                arr[index] = true;
                arr[i] = true;
                return false;
            }
            index --;
        }
        index = i + 1;
        while (index < strs.length && strs[index].length() == len){
            if (strs[index].equals(strs[i])){
                arr[index] = true;
                arr[i] = true;
                return false;
            }
            index ++;
        }
        return true;
    }
    public boolean isValid(String[] strs, int i){
        boolean flag = true;
        for (int j = 0 ; j < i; j ++){
            if (isSub(strs[j],strs[i])){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public boolean isSub(String test, String standard){
        int start = -1;
        for (int i = 0; i < standard.length(); i ++){
            start = test.indexOf(standard.charAt(i),start+1);
            if (start == -1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs ={"aabbcc", "aabbcc","e","aabc"};
        System.out.println(new LeetCode522_findLUSlength_最长特殊序列II().findLUSlength(strs));

    }
}
