package stack.Application;

import java.util.Stack;
import stack.ArrayStack;
public class bracketsMatch {
}

class Solution{
    public boolean isValid(String s){

        ArrayStack<Character> stack = new ArrayStack<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topchar = stack.pop();
                if(c == ')' && topchar != '('){
                    return false;
                }
                if(c == ']' && topchar != '['){
                    return false;
                }
                if(c == '}' && topchar != '{'){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println((new Solution().isValid("{}()[]")));
    }
}
