package LeetCode.explore_2018Hot.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2020/1/7
 */
public class wordBreakII_单词拆分II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        process(s,0,"",wordDict,res);
        return res;
    }
    public void process(String s, int index,String str, List<String> wordDict, List<String> res){
        if (index >= s.length()){
            res.add(str.substring(1,str.length()));
            return ;
        }
        for (int i = index; i <= s.length(); i ++){
            String temp = s.substring(index,i);
            if (wordDict.contains(s.substring(index,i))){
                process(s,i,str + " " + temp,wordDict,res);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = Arrays.asList("cat","cats","and","sand","dog");
        new wordBreakII_单词拆分II().wordBreak(s,list);
    }
}