package LeetCode.classify.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author  HongbinW
 * Date 2019/9/29
 *  https://leetcode-cn.com/problems/generate-parentheses/
 *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

/**
 * 递归
 */
public class LeetCode22_generateParenthesis_括号生成 {
    // 99.8%  88.8%
    public List<String> generateParenthesis(int n) {
        int need = 0;
        int ltotal = n;
        int rtotal = n;
        process(need,ltotal,rtotal,new StringBuilder());
        return list;
    }
    List<String> list = new ArrayList<>();
    public void process(int need, int ltotal, int rtotal, StringBuilder sb){
        if (need == 0 && ltotal == 0){
            list.add(sb.toString());
            return;
        }
        if (need >= 0 && ltotal > 0){
            sb.append('(');
            process(need + 1,ltotal-1,rtotal,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (need > 0){
            sb.append(')');
            process(need - 1,ltotal,rtotal-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
