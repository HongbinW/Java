package primary;

import java.util.Stack;

/**
 * @Author: HongbinW
 * @Date: 2019/4/3 12:00
 * @Version 1.0
 * @Description:
 */
public class Code18_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    //need n extra space
    public static boolean isPalindrome1(Node head){
        Stack<Integer> stack = new Stack<>();
        Node node = head;
        while(node != null){
            stack.push(node.value);
            node = node.next;
        }
        while(head != null){
            if(head.value != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }
    //need n/2 extra space
    public static boolean isPalindrome2(Node head){
        Stack<Integer> stack = new Stack<>();
        Node pfast = head;
        Node pslow = head.next;
        //如果是奇数个节点，则快指针,走到最后一个节点，慢指针走到最中间的节点的下一个节点
        while(pfast.next != null && pfast.next.next != null){
            pfast = pfast.next.next;
            pslow = pslow.next;
        }
        while(pslow != null){
            stack.push(pslow.value);
            pslow = pslow.next;
        }
        while(!stack.isEmpty()){
            if(head.value == stack.pop())
                head = head.next;
            else
                return false;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        Node pfast = head;
        Node pslow = head;
        //pslow奇数时来到中点位置，偶数时来到中点位置的前一个位置
        while(pfast.next != null && pfast.next.next != null){
            pfast = pfast.next.next;
            pslow = pslow.next;
        }
        //将后半段链表反转
        Node curNode = pslow.next;  //将pslow指针作为preNode
        pslow.next = null;
        Node nextNode = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = pslow;
            pslow = curNode;
            curNode = nextNode;
        }                           // 此时pslow到了链表尾
        curNode = pslow;
        nextNode = head;            //只是记录开头和结尾
        while(curNode != null && nextNode != null){
            if(curNode.value != nextNode.value)
                return false;
            curNode = curNode.next;
            nextNode = nextNode.next;
        }
        //恢复后半段链表
        curNode = pslow.next;
        pslow.next = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = pslow;
            pslow = curNode;
            curNode = nextNode;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(isPalindrome3(node1));
        System.out.println(isPalindrome1(node1));
        System.out.println(isPalindrome2(node1));

    }

}
