package LeetCode.classify.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2019/9/29
 *  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *  手机9键，数字，返回所有字母组合
 */

/**
 * 递归
 */
public class LeetCode17_letterCombinations_电话号码的字母组合 {
    // 99% 73%
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return list;
        }
        process(digits,new StringBuilder(),0);
        return list;
    }
    String[] strs = new String[]{
            "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    List<String> list = new ArrayList<>();
    public void process(String digits, StringBuilder sb, int start){
        if (start == digits.length()){
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < strs[digits.charAt(start) - '2'].length(); i ++){
            sb.append(strs[digits.charAt(start) - '2'].charAt(i));
            process(digits,sb,start + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
