package dp.optiamlSolution;
// https://leetcode-cn.com/problems/word-break/
// 类比 dp.allSituations/LeetCode_140_wordBreakII

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for(int i = 1 ; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(flag[j] && wordDict.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }else{
                    flag[i] = false;
                }
            }
        }
        return flag[s.length()];
    }
}
