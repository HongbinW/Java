package nowcode.LeetCode;

import java.util.ArrayList;
import java.util.Set;

public class wordBreak_ii_分解出单词 {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0){
            return list;
        }
        dfs(s,s.length(),"",dict);
        return list;
    }
    public void dfs(String s, int end, String cur, Set<String> dict){
        if (end <= 0 && cur.length() != 0){
            list.add(cur.substring(0,cur.length()-1));
        }
        for (int i = end; i >= 0; i --){
            if (dict.contains(s.substring(i,end))){
                dfs(s,i,s.substring(i,end)+" "+cur,dict);
            }
        }
    }
}
