package LeetCode.classify.string;

import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/2/5
 */
public class LeetCode227_calculate_简易计算器II {
    public int calculate(String s) {
        s = s.replace(" ","");
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < s.length()){
            int end = getNumEndIndex(s,i);
            if (end > i) {
                int num1 = Integer.parseInt(s.substring(i, end));
                stack.push(num1);
                if (end >= s.length()) {
                    break;
                }
            }
            char operator = s.charAt(end);
            i = end + 1;
            end = getNumEndIndex(s,i);
            int num2 = Integer.parseInt(s.substring(i,end));
            i = end;
            if (operator == '+'){
                stack.push(num2);
                continue;
            }else if (operator == '-'){
                stack.push(-num2);
                continue;
            }
            stack.push(process(stack.pop(),num2,operator));
        }
        while (stack.size() > 1){
            stack.push(stack.pop() + stack.pop());
        }
        return stack.pop();
    }
    public int getNumEndIndex(String s, int start){
        int end = start;
        while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9'){
            end ++;
        }
        return end ++;
    }
    public int process(int x, int y, char operator){
        switch (operator){
            case '+':
                return x + y;
            case '-':
                return y - x;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode227_calculate_简易计算器II test = new LeetCode227_calculate_简易计算器II();
        System.out.println(test.calculate("1/2+1*3"));
    }
}
