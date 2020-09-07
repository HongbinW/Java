package JZOffer.A_dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/3/15 16:43
 * @Version 1.0
 */
public class M9_StackToQueue {
    //栈实现队列
    private class StackToQueue<E>{
        Stack<E> stack1 = new Stack<>();
        Stack<E> stack2 = new Stack<>();

        public void push(E e){
            stack1.push(e);
        }

        public E poll(){
            if(stack1.isEmpty() && stack2.isEmpty()){
                return null;
            }
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
    //队列实现栈
    private class QueueToStack<E>{
        Queue<E> queue1 = new LinkedList<>();
        Queue<E> queue2 = new LinkedList<>();
        int size = 0;

        public void push(E e){
            if(queue1.isEmpty() && queue2.isEmpty()){
                queue1.add(e);
            }else if(queue1.isEmpty()){
                queue2.add(e);
            }else{
                queue1.add(e);
            }
            size ++;
        }

        public E pop(){
            if(queue2.isEmpty() && queue1.isEmpty()){
                throw new RuntimeException("The stack is empty");
            }
            if(queue1.isEmpty()){
                int count = size;
                while(count > 1){
                    queue1.add(queue2.remove());
                    count--;
                }
                size--;
                return queue2.remove();
            }else{
                int count = size;
                while(count > 1){
                    queue2.add(queue1.remove());
                    count--;
                }
                size--;
                return queue1.remove();
            }
        }
    }

    public static void main(String[] args) {
        QueueToStack q = new M9_StackToQueue().new QueueToStack();
        for(int i = 0; i < 5; i++){
            q.push(i);
        }
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (queue1.size() == 0){
                queue2.add(x);
            }else{
                queue1.add(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (queue1.size() == 0){
                while(queue2.size() > 1){
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }else{
                while (queue1.size() > 1){
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            int result;
            if (queue1.size() == 0){
                while(queue2.size() > 1){
                    queue1.add(queue2.poll());
                }
                result = queue2.poll();
                queue1.add(result);
            }else{
                while (queue1.size() > 1){
                    queue2.add(queue1.poll());
                }
                result = queue1.poll();
                queue2.add(result);
            }
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.size() == 0 && queue2.size() == 0;
        }
    }
}
