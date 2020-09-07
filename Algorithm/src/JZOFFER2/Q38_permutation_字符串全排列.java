package JZOFFER2;

import java.util.HashSet;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/6
 */
public class Q38_permutation_字符串全排列 {
    public static void main(String[] args) {
        new Q38_permutation_字符串全排列().permutation("abc");
    }
    public String[] permutation(String s) {
        HashSet<String> set = new HashSet<>();
        if (s == null || s.length() == 0){
            return new String[0];
        }
        process(s.toCharArray(),0,set);
        int index = 0;
        String[] res = new String[set.size()];
        for (String str : set){
            res[index++] = str;
        }
        return res;
    }

    public void process(char[] chs, int start, HashSet<String> set){
        if (start == chs.length){
            set.add(new String(chs));
            return;
        }
        for (int i = start; i < chs.length; i ++){
            swap(chs,i,start);
            process(chs,start+1,set);
            swap(chs,i,start);
        }
    }
    public void swap(char[] chs, int i, int j){
        char c = chs[i];
        chs[i] = chs[j];
        chs[j] = c;
    }

}
