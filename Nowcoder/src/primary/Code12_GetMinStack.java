package primary;

/**
 * Description
 * Author  HongbinW
 * Date 2019/2/13
 */

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：1.pop、push、getMin操作的时间复杂度都是O(1)
 *       2.设计的栈类型可以使用现成的栈结构
 * 参考Code_02_GetMinStack
 */
public class Code12_GetMinStack {
    public static class MyStack1{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack1(){
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        public void push(int value){
            dataStack.push(value);
            if(minStack.isEmpty()){
                minStack.push(value);
            }else if(minStack.peek() <= value) {
                int newmin = minStack.peek();
                minStack.push(newmin);
            }else{
                minStack.push(value);
            }
        }
        public int pop(){
            if(dataStack.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            minStack.pop();
            return dataStack.pop();
        }
        public int peek(){
            return dataStack.peek();
        }
        public int getMin(){
            if(this.minStack.isEmpty()){
                throw new RuntimeException("The Stack is empty");
            }
            return minStack.peek();
        }
    }
    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
