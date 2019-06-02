package dp.allSituations;
// https://leetcode-cn.com/problems/word-break-ii/
// 类比 dp.optiamlSolution/LeetCode_139_wordBreak

// https://www.nowcoder.com/practice/bd73f6b52fdc421d91b14f9c909f9104?tpId=46&tqId=29040&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
import java.util.ArrayList;
import java.util.Set;

public class LeetCode_140_wordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        process(s,s.length(),"",dict,res);
        return res;
    }

    public static void process(String s, int index, String str, Set<String> wordDict, ArrayList<String> res){
        if (index <= 0){
            if (str.length() > 0){
                res.add(str.substring(0,str.length()-1));
            }
        }
        for (int i = index; i >= 0; i--){
            if (wordDict.contains(s.substring(i,index))){
                process(s,i,s.substring(i,index) + " " + str,wordDict,res);
            }
        }
    }
}
