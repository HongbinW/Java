package nowcode.LeetCode;

import java.util.Stack;

//https://www.nowcoder.com/practice/22f9d7dd89374b6c8289e44237c70447?tpId=46&tqId=29031&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
public class evalRPN_逆波兰式 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i ++){
            switch (tokens[i]){
                case "+":{
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case "-":{
                    int sub = stack.pop();
                    int subed = stack.pop();
                    stack.push(subed - sub);
                    break;
                }
                case "*":{
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case "/":{
                    int div = stack.pop();
                    int dived = stack.pop();
                    stack.push(dived / div);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new evalRPN_逆波兰式().evalRPN(new String[]{"4", "3", "-"}));
    }
}
