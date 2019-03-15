package JZOffer;

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
}
