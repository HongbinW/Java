package nowcode.LeetCode.middle;

import java.util.*;

public class wordBreak_ii_分解出单词 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("dog");
        wordDict.add("cat");
        new  wordBreak_ii_分解出单词().wordBreak("dogcatdog", wordDict);
    }
    Map<String,List<String>> cuttingCache = new HashMap<>();        // 排除重复
    /**
     * s--> 拆分成prefix s.subString(prefix.length())
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> cuttingResult = cuttingCache.get(s);
        if (cuttingResult != null) {
            return cuttingResult;
        }

        List<String> result = new ArrayList<>();
        for (String prefix : wordDict) {        //遍历字典

            if (!s.startsWith(prefix)) {        //必须是以字典中的开头，
                continue;
            }

            String left = s.substring(prefix.length()); // 剩下的部分
            if (left.length() == 0) {       // 如果走完了，那说明从字典取出的部分刚好为s则直接作为结果好了
                result.add(prefix);
                continue;
            }

            List<String> childResult = wordBreak(left, wordDict);   // 剩下的部分继续递归
            if (childResult == null) {
                continue;
            }
            for (String child : childResult) {      // 组装所有可能的情况，即当前prefix与后面拆分形成的所有字符串拼接
                result.add(prefix + " " + child);
            }
        }
        cuttingCache.put(s,result);
        return result;
    }
    // 超时
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
