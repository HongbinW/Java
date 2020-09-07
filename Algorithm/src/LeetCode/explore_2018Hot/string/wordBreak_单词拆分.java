package LeetCode.explore_2018Hot.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description
 * Author  HongbinW
 * Date 2020/1/7
 */
public class wordBreak_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i ++){
            for (int j = i - 1; j >= 0; j --){
                if (flag[j] && wordDict.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}
