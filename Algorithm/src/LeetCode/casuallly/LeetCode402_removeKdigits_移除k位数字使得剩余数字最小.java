package LeetCode.casuallly;

import java.util.LinkedList;

/**
 * Description
 * Author  HongbinW
 * Date 2020/8/16
 */
public class LeetCode402_removeKdigits_移除k位数字使得剩余数字最小 {
    public String removeKdigits(String num, int k) {
        while (k >= num.length()){
            return "0";
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] chs = num.toCharArray();
        // 把所有的字符都压到队列里
        for (char c : chs){
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > c){
                stack.removeLast();
                k --;
            }
            stack.addLast(c);
        }
        // 如果走完，k还大于0，说明整体是从小到大的，就把大的这几个去掉好了。
        // 因为去掉k位，所以，剩下的位数应该是相同的（有0除外）
        while (k > 0){
            stack.removeLast();
            k --;
        }

        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (char c : stack){
            if (isZero && c == '0'){
                continue;
            }
            isZero = false;
            sb.append(c);
        }
        if (sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
