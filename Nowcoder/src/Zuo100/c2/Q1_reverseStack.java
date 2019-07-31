package Zuo100.c2;


import java.util.Stack;

public class Q1_reverseStack {
    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int temp = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(temp);
    }

    //取最后一个元素并从栈中移除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int temp = stack.pop();
        if (stack.size() == 0){ //最后一个元素不用压栈了
            return temp;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(temp);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < 6; i ++){
            stack.push(i);
        }
        reverseStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
