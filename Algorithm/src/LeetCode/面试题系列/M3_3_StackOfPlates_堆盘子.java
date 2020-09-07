package LeetCode.面试题系列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/26
 */

// OJ 没过！

public class M3_3_StackOfPlates_堆盘子 {
    public static void main(String[] args) {
        StackOfPlates test = new M3_3_StackOfPlates_堆盘子().new StackOfPlates(1);
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.popAt(1));
        System.out.println(test.popAt(1));
        System.out.println(test.popAt(2));
    }
    class StackOfPlates {
        class Node{
            Node pre;
            Node next;
            Stack<Integer> stack;
            Node(Stack<Integer> stack){
                this.stack = stack;
            }
        }
        Node head;
        Node tail;
        int cap;
        public StackOfPlates(int cap) {
            this.cap = cap;
        }

        public void push(int val) {
            if (head == null){
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                Node node = new Node(stack);
                head = node;
                tail = node;
            }else{
                if (tail.stack.size() == cap){
                    Stack<Integer> stack = new Stack<>();
                    stack.push(val);
                    Node node = new Node(stack);
                    tail.next = node;
                    node.pre = tail;
                    tail = node;
                }else{
                    tail.stack.push(val);
                }
            }
        }

        public int pop() {
            if (tail == null || cap == 0){
                return -1;
            }
            int res = tail.stack.pop();
            if (tail.stack.isEmpty()){
                tail = tail.pre;
            }
            if (tail == null){
                head = null;
            }
            return res;
        }

        public int popAt(int index) {
            if (tail == null || cap == 0){
                return -1;
            }
            Node cur = head;
            while (index > 0 && cur.next != null){
                cur = cur.next;
                index --;
            }
            if (index != 0 || cur == null){
                return -1;
            }
            int res = cur.stack.pop();
            if (cur.stack.isEmpty()){
                if (cur.pre != null)
                    cur.pre.next = cur.next;
                else{
                    head = cur.next;
                }
                if (cur.next != null)
                    cur.next.pre = cur.pre;
                else{
                    tail = cur.pre;
                }
            }
            return res;
        }
    }
}
