package LeetCode.explore_2018Hot.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongbinW
 * @Date: 2020/1/4 11:47
 * @Version 1.0
 * @Description:
 */
public class partition_分割回文串 {
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0){
            return res;
        }
        process(s,0);
        return res;
    }
    public void process(String s, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(temp));
        }
        for (int i = start + 1; i <= s.length();i ++){
            if (!valid(s,start,i-1)){
                continue;
            }
            temp.add(s.substring(start,i));
            process(s,i);
            temp.remove(temp.size()-1);
        }
    }
    public boolean valid(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new partition_分割回文串().partition("aab");
        for (List<String> list : res){
            for (String s : list){
                System.out.println(s);
            }
            System.out.println();
            System.out.println();
        }
    }
}
